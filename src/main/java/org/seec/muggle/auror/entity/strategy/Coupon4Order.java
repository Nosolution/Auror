package org.seec.muggle.auror.entity.strategy;

import lombok.Data;
import org.seec.muggle.auror.po.CouponPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/17 20:58
 * @Version 1.0
 **/
@Data
public class Coupon4Order {
    Long id;
    String couponName;
    String description;
    Integer discount;
    String url;


    public Coupon4Order(CouponPO couponPO) {
        this.id = couponPO.getId();
        this.couponName = couponPO.getCouponName();
        this.description = couponPO.getDescription();
        this.discount = couponPO.getDiscount();
        this.url = couponPO.getUrl();
    }
}
