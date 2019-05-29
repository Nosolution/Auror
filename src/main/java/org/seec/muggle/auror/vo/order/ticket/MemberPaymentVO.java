package org.seec.muggle.auror.vo.order.ticket;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:33
 * @Version 1.0
 **/
public class MemberPaymentVO {
    CouponsAcquirementVO[] couponsGot;

    public CouponsAcquirementVO[] getCouponsGot() {
        return couponsGot;
    }

    public void setCouponsGot(CouponsAcquirementVO[] couponsGot) {
        this.couponsGot = couponsGot;
    }
}
