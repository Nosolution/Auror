package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 18:54
 * @Version 1.0
 **/
public interface StrategyService4Account {
    UserCouponsVO[] getCouponsByUser(Long userId);
}
