package org.seec.muggle.auror.vo.user.coupon;

import lombok.Data;

import java.util.Date;

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

}
