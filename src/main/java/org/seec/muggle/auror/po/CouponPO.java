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
    Long id;
    String couponName;
    String description;
    Integer discount;
    Integer threshold;
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
