package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.entity.strategy.Coupon4Account;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;

/**
 * @Description 策略模块提供给Account模块的接口
 * @Author jyh
 * @Date 2019/6/8 18:54
 * @Version 1.0
 **/
public interface StrategyService4Account {
    /**
     * @Author jyh
     * @Description //获取用户持有的优惠券
     * @Date 19:12 2019/6/8
     * @Param [userId]
     * @return org.seec.muggle.auror.vo.user.coupon.UserCouponsVO[]
     **/
    Coupon4Account[] getCouponsByUser(Long userId);
}
