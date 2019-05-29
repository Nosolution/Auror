package org.seec.muggle.auror.vo.order.purchase;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:57
 * @Version 1.0
 **/
public class VipPurchaseForm {
    Long  memberStrategyId;//会员卡种类
    Integer cost;

    public Long getMemberStrategyId() {
        return memberStrategyId;
    }

    public void setMemberStrategyId(Long memberStrategyId) {
        this.memberStrategyId = memberStrategyId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
