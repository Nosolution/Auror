package org.seec.muggle.auror.vo.order.third_party;

import org.seec.muggle.auror.vo.order.member.CouponsForm;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:21
 * @Version 1.0
 **/
public class ThirdPartyPaymentForm {
    Long orderId;
    CouponsForm[] coupons;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CouponsForm[] getCoupons() {
        return coupons;
    }

    public void setCoupons(CouponsForm[] coupons) {
        this.coupons = coupons;
    }
}
