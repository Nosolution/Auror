package org.seec.muggle.auror.blImpl.strategy;

import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.bl.strategy.StrategyService4Account;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.strategy.StrategyMapper;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.order.member.CouponsForm;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;
import org.seec.muggle.auror.vo.strategy.coupon_gift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    StrategyMapper strategyMapper;

    @Override
    public RefundStrategyVO getRefundStrategy() {
        return new RefundStrategyVO(strategyMapper.selectRefundStrategy().get(0));
    }

    @Override
    public BasicVO updateRefundStrategy(Double rate, Integer beforeTime) {
        RefundPO po = new RefundPO();
        po.setBeforeTime(beforeTime);
        po.setRate(rate);
        strategyMapper.updateRefundStrategy(po);
        return new BasicVO();
    }

    @Override
    public RefundPO getRefund() {
        return strategyMapper.selectRefundStrategy().get(0);
    }

    @Override
    public BasicVO createMemberStrategy(String name, String url, Integer threshold, Double rate) {
        MemberStrategyPO po = new MemberStrategyPO(name, url, threshold, rate);
        strategyMapper.insertMemberStrategy(po);
        return new BasicVO();
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
    public BasicVO createEvent(EventForm form) {
        EventPO po = new EventPO(form.getStartTime(), form.getEndTime(), form.getEventDescription(), form.getEventName(), form.getCouponExpiration());
        CouponPO couponPO = new CouponPO(form.getCouponName(), form.getCouponDescription(), form.getCouponDiscount(), form.getCouponThreshold(), form.getCouponPictureUrl());
        strategyMapper.insertCoupon(couponPO);

        po.setCouponId(couponPO.getId());
        po.setExpiration(form.getCouponExpiration());
        strategyMapper.insertEvent(po);

        for (int i = 0; i < form.getMoviesIncluded().length; i++) {
            strategyMapper.insertEventMovie(po.getId(), form.getMoviesIncluded()[i]);
        }
        return new BasicVO();
    }

    @Override
    public BasicVO deleteEvent(Long eventId) {
        strategyMapper.deleteEvent(eventId);
        strategyMapper.deleteEventMovie(eventId);
        return new BasicVO();
    }

    @Override
    public EventVO[] getEvents() {
        List<EventPO> events = strategyMapper.getEvents();
        List<EventVO> res = new ArrayList<>();
        events.forEach(o -> {
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
    public BasicVO deleteMemberStrategy(Long strategyId) {
        List<Long> isInUsed = strategyMapper.getUsersByMemberStrategyId(strategyId);
        if (isInUsed.size() == 0) {
            strategyMapper.deleteMemberStrategy(strategyId);
            BasicVO vo = new BasicVO();
            vo.setSucc(true);
            return vo;
        } else {
            return buildFailureBasicVO(isInUsed);
        }
    }

    @Override
    public BasicVO updateMemberStrategy(MemberVaryForm form) {
        List<Long> isInUsed = strategyMapper.getUsersByMemberStrategyId(form.getMemberStrategyId());
        if (isInUsed.size() == 0) {
            strategyMapper.updateMemberStrategy(form);
            BasicVO vo = new BasicVO();
            vo.setSucc(true);
            return vo;
        } else {
            return buildFailureBasicVO(isInUsed);
        }
    }

    private BasicVO buildFailureBasicVO(List<Long> isInUsed) {
        BasicVO vo = new BasicVO();
        vo.setSucc(false);
        String using = "";
        StringBuffer buffer = new StringBuffer(using);
        isInUsed.forEach(o -> {
            buffer.append("用户: ").append(o);
        });
        buffer.append("正处于该策略中，操作失败");
        vo.setMsg(buffer.toString());
        return vo;
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
        uc.forEach(o -> {
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
    public BasicVO sendCoupon(CouponGiftForm form) {
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
        return new BasicVO();
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
