package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.vo.strategy.coupongift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;

/**
 * @Description 策略模块的接口
 * @Author jyh
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
public interface StrategyService {
    /**
     * @Author jyh
     * @Description //获取退票策略
     * @Date 15:04 2019/6/5
     * @Param []
     * @return org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO
     **/
    RefundStrategyVO getRefundStrategy();

    /**
     * @Author jyh
     * @Description //更新退票策略
     * @Date 15:15 2019/6/5
     * @Param [rate, beforeTime]
     * @return void
     **/
    void updateRefundStrategy(Double rate, Integer beforeTime);

    /**
     * @Author jyh
     * @Description //新增会员卡类型
     * @Date 15:35 2019/6/5
     * @Param [name, url, threshold, rate]
     * @return void
     **/
    void createMemberStrategy(String name, String url, Integer threshold, Double rate);

    /**
     * @Author jyh
     * @Description //获取会员卡类型
     * @Date 16:35 2019/6/5
     * @Param []
     * @return org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO[]
     **/
    MemberVarietyVO[] getMemberStrategy();

    /**
     * @Author jyh
     * @Description //新增优惠活动
     * @Date 16:37 2019/6/6
     * @Param [form]
     * @return void
     **/
    void createEvent(EventForm form);
    /**
     * @Author jyh
     * @Description //删除优惠活动
     * @Date 17:28 2019/6/7
     * @Param [eventId]
     * @return void
     **/
    void deleteEvent(Long eventId);

    /**
     * @Author jyh
     * @Description //获取所有的优惠活动
     * @Date 18:38 2019/6/7
     * @Param []
     * @return org.seec.muggle.auror.vo.strategy.event.EventVO[]
     **/
    EventVO[] getEvents();

    /**
     * @Author jyh
     * @Description //删除会员卡类型，如果有人正使用该类型，提醒无法删除
     * @Date 18:40 2019/6/7
     * @Param [strategyId]
     * @return void
     **/
    void deleteMemberStrategy(Long strategyId);

   /**
    * @Author jyh
    * @Description //更新会员卡类型，如果有人正使用该类型，提醒无法更新
    * @Date 18:50 2019/6/7
    * @Param [form]
    * @return void
    **/
    void updateMemberStrategy(MemberVaryForm form);

    /**
     * @Author jyh
     * @Description //赠送优惠券，会新增一个优惠券类型并进行用户关联
     * @Date 19:00 2019/6/8
     * @Param [form]
     * @return void
     **/
    void sendCoupon(CouponGiftForm form);

}
