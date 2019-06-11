package org.seec.muggle.auror.vo.strategy.coupon_gift;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:26
 * @Version 1.0
 **/
@Data
public class CouponGiftForm {
    Long[] userList;
    Date startTime;
    Date endTime;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Integer couponDiscount;// 金额
    Integer couponThreshold; //优惠券使用门槛
    String couponExpiration;

}
