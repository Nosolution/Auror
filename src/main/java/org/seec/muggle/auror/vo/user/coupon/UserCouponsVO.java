package org.seec.muggle.auror.vo.user.coupon;

import lombok.Data;
import org.seec.muggle.auror.entity.strategy.Coupon4Account;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:04
 * @Version 1.0
 **/
@Data
public class UserCouponsVO {
    Long couponId;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Integer couponDiscount;
    Integer couponThreshold; //使用门槛
    String couponStartTime;
    String couponEndTime;
    String couponExpiration; //有效期长度

    public UserCouponsVO(Coupon4Account accounts) {
        this.couponId = accounts.getCouponId();
        this.couponName = accounts.getCouponName();
        this.couponDescription = accounts.getCouponDescription();
        this.couponPictureUrl = accounts.getCouponPictureUrl();
        this.couponDiscount = accounts.getCouponDiscount();
        this.couponThreshold = accounts.getCouponThreshold();
        this.couponStartTime = accounts.getCouponStartTime();
        this.couponEndTime = accounts.getCouponEndTime();
        this.couponExpiration = accounts.getCouponExpiration();
    }
}
