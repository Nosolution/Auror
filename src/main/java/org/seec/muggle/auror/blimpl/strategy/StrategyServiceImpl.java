package org.seec.muggle.auror.blimpl.strategy;

import org.seec.muggle.auror.bl.message.MessageService4Strategy;
import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.bl.strategy.StrategyService4Account;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.strategy.StrategyMapper;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.order.member.CouponsForm;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;
import org.seec.muggle.auror.vo.strategy.coupongift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
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
    public RefundPO getRefund() {
        return strategyMapper.getRefundStrategy().get(0);
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
                vo.setPurchaseThreshold(o.getThreshold());
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
        Message message = new Message();
        message.setType(4);
        message.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        message.setTitle("新优惠活动提示");
        message.setContent("新的优惠活动公布了，不如我们把它……");
        messageService4Strategy.broadcastNewEvent(message);
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
    public MemberStrategyPO getMemberStrategyById(Long id) {
        return strategyMapper.selectMemberStrategyById(id);
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
    public UserCouponsVO[] getCouponsByUser(Long userId) {
        List<UserCouponPO> uc = strategyMapper.getUserCoupons(userId);
        List<UserCouponsVO> vos = new ArrayList<>();
        uc.stream()
                .sorted(Comparator.comparing(UserCouponPO::getEnd).reversed())
                .forEach(o -> {
                    UserCouponsVO vo = new UserCouponsVO();
                    CouponPO couponPO = strategyMapper.getCouponById(o.getCouponId());
                    vo.setCouponDescription(couponPO.getDescription());
                    vo.setCouponDiscount(couponPO.getDiscount());
                    vo.setCouponEndTime(DateUtil.dateToString(o.getEnd()));
                    vo.setCouponId(o.getCouponId());
                    vo.setCouponName(couponPO.getCouponName());
                    vo.setCouponPictureUrl(couponPO.getUrl());
                    vo.setCouponThreshold(couponPO.getThreshold());
                    vo.setCouponStartTime(DateUtil.dateToString(o.getStart()));
                    vo.setCouponExpiration("");
                    vos.add(vo);
                });
        return vos.toArray(new UserCouponsVO[vos.size()]);
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
        Message message = new Message();
        message.setTitle("优惠券获取提示");
        message.setStatus(0);
        message.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        message.setContent("您获取了新的优惠券，请于卡包查看。");
        message.setType(0);
        messageService4Strategy.sendCouponReceiversMessages(message, form.getUserList());
    }

    @Override
    public List<MemberStrategyPO> selectAllMemberStrategy() {
        return strategyMapper.selectAllMemberStrategies().stream().sorted(Comparator.comparing(MemberStrategyPO::getThreshold)).collect(Collectors.toList());
    }

    @Override
    public Integer cutDownByCoupons(CouponsForm[] form, Long userId) {
        int cut = 0;
        for (int i = 0; i < form.length; i++) {
            CouponPO couponPO = strategyMapper.getCouponById(form[i].getCouponId());
            cut += couponPO.getDiscount();
            strategyMapper.deleteCouponUser(userId, couponPO.getId());
        }
        ;
        return cut;
    }

    /**
     * @Author jyh
     * @Description //TODO 优惠活动时间判断
     * @Date 8:53 2019/6/13
     * @Param [movieId, userId]
     * @return java.util.List<org.seec.muggle.auror.po.CouponPO>
     **/
    @Override
    public List<CouponPO> sendCoupons(Long movieId, Long userId) {
        List<Long> events = strategyMapper.getEventIdsByMovieId(movieId);
        List<CouponPO> pos = new ArrayList<>();
        for (Long event : events) {
            EventPO eventPO = strategyMapper.getEventsById(event);
            Long coupon = eventPO.getCouponId();
            CouponPO po = strategyMapper.getCouponById(coupon);
            pos.add(po);
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
