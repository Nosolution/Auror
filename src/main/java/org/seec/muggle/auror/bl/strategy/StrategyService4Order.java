package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.entity.strategy.Coupon4Order;
import org.seec.muggle.auror.entity.strategy.MemberStrategy4Order;
import org.seec.muggle.auror.po.RefundPO;
import org.seec.muggle.auror.vo.order.member.CouponsForm;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;

import java.util.List;

/**
 * @Description 策略模块提供给Order的接口
 * @Author jyh
 * @Date 2019/6/5 16:25
 * @Version 1.0
 **/
public interface StrategyService4Order {
    /**
     * @return org.seec.muggle.auror.po.RefundPO
     * @Author jyh
     * @Description //获取退款金额
     * @Date 17:50 2019/6/5
     * @Param []
     **/
    RefundPO getRefund();

    /**
     * @return java.util.List<org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO>
     * @Author jyh
     * @Description //获取当前（消费金额条件下）可用的优惠券
     * @Date 18:15 2019/6/5
     * @Param [cost, userId]
     **/
    List<AvailableCouponsVO> getCouponsByCost(Integer cost, Long userId);

    /**
     * @return java.util.List<org.seec.muggle.auror.po.MemberStrategyPO>
     * @Author jyh
     * @Description //获取所有会员卡类型
     * @Date 18：30 2019/6/7
     * @Param []
     **/
    List<MemberStrategy4Order> selectAllMemberStrategy();

    /**
     * @return java.lang.Integer
     * @Author jyh
     * @Description //获取打折后的金额
     * @Date 18：45 2019/6/7
     * @Param [form, userId]
     **/
    Integer cutDownByCoupons(CouponsForm[] form, Long userId);

    /**
     * @return java.util.List<org.seec.muggle.auror.po.CouponPO>
     * @Author jyh
     * @Description //赠送优惠券
     * @Date 19：08 2019/6/7
     * @Param [movieId, userId]
     **/
    List<Coupon4Order> sendCoupons(Long movieId, Long userId);


}
