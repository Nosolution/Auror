package org.seec.muggle.auror.entity.strategy;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/17 20:58
 * @Version 1.0
 **/
@Data
public class Coupon4Account {
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
