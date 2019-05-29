package org.seec.muggle.auror.vo.order.ticket;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:19
 * @Version 1.0
 **/
public class MemberPaymentForm {
    Long memberId;
    Long orderId;
    CouponsForm[] coupons;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

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
