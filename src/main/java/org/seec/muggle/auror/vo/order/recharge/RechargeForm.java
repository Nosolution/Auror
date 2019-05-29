package org.seec.muggle.auror.vo.order.recharge;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:22
 * @Version 1.0
 **/
public class RechargeForm {
    Long memberId;
    Integer cost; // 充值金额

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
