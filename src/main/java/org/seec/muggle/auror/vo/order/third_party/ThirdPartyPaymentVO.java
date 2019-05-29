package org.seec.muggle.auror.vo.order.third_party;

import org.seec.muggle.auror.vo.order.member.CouponsAcquirementVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:25
 * @Version 1.0
 **/
public class ThirdPartyPaymentVO {
    CouponsAcquirementVO[] couponsGot;

    public CouponsAcquirementVO[] getCouponsGot() {
        return couponsGot;
    }

    public void setCouponsGot(CouponsAcquirementVO[] couponsGot) {
        this.couponsGot = couponsGot;
    }
}
