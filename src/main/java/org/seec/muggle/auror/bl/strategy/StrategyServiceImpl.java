package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.dao.strategy.StrategyMapper;
import org.seec.muggle.auror.entity.strategy.*;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.service.strategy.StrategyService;
import org.seec.muggle.auror.util.DateConverterUtil;
import org.seec.muggle.auror.vo.order.member.CouponsForm;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;
import org.seec.muggle.auror.vo.strategy.coupongift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
@Service
public class StrategyServiceImpl implements StrategyService, StrategyService4Order, StrategyService4Account, StrategyService4Member {

    @Autowired
    MessageService4Strategy messageService4Strategy;

    @Autowired
    StrategyMapper strategyMapper;

    @Override
    public RefundStrategyVO getRefundStrategy() {
        return new RefundStrategyVO(strategyMapper.getRefundStrategy().get(0));
    }

    @Override
    public void updateRefundStrategy(Double rate, Integer beforeTime) {
        RefundPO po = new RefundPO();
        po.setBeforeTime(beforeTime);
        po.setRate(rate);
        strategyMapper.updateRefundStrategy(po);
    }

    @Override
    public Refund4Order getRefund() {
        RefundPO refundPO = strategyMapper.getRefundStrategy().get(0);
        Refund4Order refund4Order = new Refund4Order();
        refund4Order.setBeforeTime(refundPO.getBeforeTime());
        refund4Order.setRate(refundPO.getRate());
        return refund4Order;
    }

    @Override
    public void createMemberStrategy(String name, String url, Integer threshold, Double rate) {
        MemberStrategyPO po = new MemberStrategyPO(name, url, threshold, rate);
        strategyMapper.insertMemberStrategy(po);
    }

    @Override
    public MemberVarietyVO[] getMemberStrategy() {
        List<MemberStrategyPO> strategyPOS = strategyMapper.selectAllMemberStrategies();
        if (strategyPOS.size() == 0) {
            return null;
        } else {
            List<MemberVarietyVO> vos = new ArrayList<>();
            strategyPOS.forEach(o -> {
                MemberVarietyVO vo = new MemberVarietyVO();
                vo.setMemberDiscountRate(o.getRate());
                vo.setMemberPictureUrl(o.getUrl());
                vo.setPurchaseThreshold(o.getPrice());
                vo.setMemberStrategyId(o.getId());
                vo.setMemberStrategyName(o.getName());
                vos.add(vo);
            });
            return vos.toArray(new MemberVarietyVO[vos.size()]);
        }

    }

    @Override
    public void createEvent(EventForm form) {
        EventPO po = new EventPO(form.getStartTime(), form.getEndTime(), form.getEventDescription(), form.getEventName(), form.getCouponExpiration());
        CouponPO couponPO = new CouponPO(form.getCouponName(), form.getCouponDescription(), form.getCouponDiscount(), form.getCouponThreshold(), form.getCouponPictureUrl());
        strategyMapper.insertCoupon(couponPO);

        po.setCouponId(couponPO.getId());
        po.setExpiration(form.getCouponExpiration());
        strategyMapper.insertEvent(po);

        for (int i = 0; i < form.getMoviesIncluded().length; i++) {
            strategyMapper.insertEventMovie(po.getId(), form.getMoviesIncluded()[i]);
        }

        //发送消息提示
        MessagePO messagePO = new MessagePO();
        messagePO.setType(4);
        messagePO.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        messagePO.setTitle("新优惠活动提示");
        messagePO.setContent("新的优惠活动公布了，不如我们把它……");
        messageService4Strategy.broadcastNewEvent(messagePO);
    }

    @Override
    public void deleteEvent(Long eventId) {
        strategyMapper.deleteEvent(eventId);
        strategyMapper.deleteEventMovie(eventId);
    }

    @Override
    public EventVO[] getEvents() {
        List<EventPO> events = strategyMapper.getEvents();
        List<EventVO> res = new ArrayList<>();
        events.stream()
                .sorted(Comparator.comparing(EventPO::getStartTime).reversed())
                .forEach(o -> {
                    EventVO vo = new EventVO(o, strategyMapper.getCouponById(o.getCouponId()), strategyMapper.getMoviesByEventId(o.getId()));
                    res.add(vo);
                });
        return res.toArray(new EventVO[res.size()]);
    }

    @Override
    public MemberStrategy4Member getMemberStrategyById(Long id) {
        MemberStrategyPO po = strategyMapper.selectMemberStrategyById(id);
        return new MemberStrategy4Member(po);
    }

    @Override
    public void deleteMemberStrategy(Long strategyId) {
        List<Long> isInUsed = strategyMapper.getUsersByMemberStrategyId(strategyId);
        if (isInUsed.size() == 0) {
            strategyMapper.deleteMemberStrategy(strategyId);
        } else {
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, buildFailureMsg(isInUsed));
        }
    }

    @Override
    public void updateMemberStrategy(MemberVaryForm form) {
        List<Long> isInUsed = strategyMapper.getUsersByMemberStrategyId(form.getMemberStrategyId());
        if (isInUsed.size() == 0) {
            strategyMapper.updateMemberStrategy(form);
        } else {
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, buildFailureMsg(isInUsed));
        }
    }


    private String buildFailureMsg(List<Long> isInUsed) {
        StringBuffer buffer = new StringBuffer();
        isInUsed.forEach(o -> {
            buffer.append("用户: ").append(o);
        });
        buffer.append("正处于该策略中，操作失败");
        return buffer.toString();
    }


    @Override
    public List<AvailableCouponsVO> getCouponsByCost(Integer cost, Long userId) {
        List<CouponPO> couponPOS = strategyMapper.getCouponByCost(cost);
        List<AvailableCouponsVO> couponsVOS = new ArrayList<>();
        for (int i = 0; i < couponPOS.size(); i++) {
            List<Date> dates = strategyMapper.getCouponsTimes(userId, couponPOS.get(i).getId());
            for (int j = 0; j < dates.size(); j++) {
                AvailableCouponsVO vo = new AvailableCouponsVO(couponPOS.get(i).getId(), couponPOS.get(i).getCouponName(), couponPOS.get(i).getDiscount(), dates.get(i));
                couponsVOS.add(vo);
            }
        }
        return couponsVOS;
    }

    @Override
    public Coupon4Account[] getCouponsByUser(Long userId) {
        List<UserCouponPO> uc = strategyMapper.getUserCoupons(userId);
        List<Coupon4Account> vos = new ArrayList<>();
        uc.stream()
                .sorted(Comparator.comparing(UserCouponPO::getEnd).reversed())
                .forEach(o -> {
                    Coupon4Account coupon4Account = new Coupon4Account();
                    CouponPO couponPO = strategyMapper.getCouponById(o.getCouponId());
                    coupon4Account.setCouponDescription(couponPO.getDescription());
                    coupon4Account.setCouponDiscount(couponPO.getDiscount());
                    coupon4Account.setCouponEndTime(DateConverterUtil.dateToString(o.getEnd()));
                    coupon4Account.setCouponId(o.getCouponId());
                    coupon4Account.setCouponName(couponPO.getCouponName());
                    coupon4Account.setCouponPictureUrl(couponPO.getUrl());
                    coupon4Account.setCouponThreshold(couponPO.getThreshold());
                    coupon4Account.setCouponStartTime(DateConverterUtil.dateToString(o.getStart()));
                    coupon4Account.setCouponExpiration("");
                    vos.add(coupon4Account);
                });
        return vos.toArray(new Coupon4Account[vos.size()]);
    }

    @Override
    public void sendCoupon(CouponGiftForm form) {
        CouponPO po = new CouponPO();
        po.setCouponName(form.getCouponName());
        po.setDiscount(form.getCouponDiscount());
        po.setThreshold(form.getCouponThreshold());
        po.setUrl(form.getCouponPictureUrl());
        po.setDescription(form.getCouponDescription());
        strategyMapper.insertCoupon(po);

        for (int i = 0; i < form.getUserList().length; i++) {
            UserCouponPO ucPO = new UserCouponPO();
            ucPO.setCouponId(po.getId());
            ucPO.setStart(form.getStartTime());
            ucPO.setEnd(form.getEndTime());
            ucPO.setUserId(form.getUserList()[i]);
            strategyMapper.insertUserCoupon(ucPO);
        }
        //发送提醒消息;
        MessagePO messagePO = new MessagePO();
        messagePO.setTitle("优惠券获取提示");
        messagePO.setStatus(0);
        messagePO.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        messagePO.setContent("您获取了新的优惠券，请于卡包查看。");
        messagePO.setType(0);
        messageService4Strategy.sendCouponReceiversMessages(messagePO, form.getUserList());
    }

    @Override
    public List<MemberStrategy4Order> selectAllMemberStrategy() {
        List<MemberStrategyPO> pos = strategyMapper.selectAllMemberStrategies().stream().sorted(Comparator.comparing(MemberStrategyPO::getPrice)).collect(Collectors.toList());
        List<MemberStrategy4Order> memberStrategy4Orders = new ArrayList<>();
        for (MemberStrategyPO po : pos) {
            MemberStrategy4Order order = new MemberStrategy4Order(po);
            memberStrategy4Orders.add(order);
        }
        return memberStrategy4Orders;
    }

    @Override
    public Integer cutDownByCoupons(CouponsForm[] form, Long userId) {
        int cut = 0;
        for (CouponsForm couponsForm : form) {
            CouponPO couponPO = strategyMapper.getCouponById(couponsForm.getCouponId());
            cut += couponPO.getDiscount();
            strategyMapper.deleteCouponUser(userId, couponPO.getId());
        }

        return cut;
    }

    @Override
    public List<Coupon4Order> sendCoupons(Long movieId, Long userId) {
        List<Long> events = strategyMapper.getEventIdsByMovieId(movieId);
        List<Coupon4Order> pos = new ArrayList<>();
        for (Long event : events) {
            EventPO eventPO = strategyMapper.getEventsById(event);
            Long coupon = eventPO.getCouponId();
            CouponPO po = strategyMapper.getCouponById(coupon);
            Coupon4Order coupon4Order = new Coupon4Order(po);
            pos.add(coupon4Order);
            UserCouponPO userCouponPO = new UserCouponPO();
            userCouponPO.setUserId(userId);
            userCouponPO.setStart(new Date());
            userCouponPO.setEnd(dayPlusTimes(new Date(), eventPO.getExpiration()));
            userCouponPO.setCouponId(coupon);
            strategyMapper.insertUserCoupon(userCouponPO);
        }
        return pos;
    }

    private Date dayPlusTimes(Date current, Integer times) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.DATE, times);
        return calendar.getTime();
    }


}
