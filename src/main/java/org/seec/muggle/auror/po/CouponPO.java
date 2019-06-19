package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 21:44
 * @Version 1.0
 **/
@Data
public class CouponPO {
    //优惠券id
    Long id;
    //优惠券名称
    String couponName;
    //优惠券描述
    String description;
    //优惠金额
    Integer discount;
    //使用的起始金额
    Integer threshold;
    //优惠券背景图url
    String url;

    public CouponPO() {

    }

    public CouponPO(String couponName, String description, Integer discount, Integer threshold, String url) {
        this.couponName = couponName;
        this.description = description;
        this.discount = discount;
        this.threshold = threshold;
        this.url = url;
    }

}
