package org.seec.muggle.auror.vo.strategy.member;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:21
 * @Version 1.0
 **/
public class MemberVaryForm {
    Long memberStrategyId;
    String memberStrategyName;
    String memberPictureUrl;
    Integer purchaseThreshold; // 购买(初始充值)起始金额
    Double memberDiscountRate;// 折扣率

    public Long getMemberStrategyId() {
        return memberStrategyId;
    }

    public void setMemberStrategyId(Long memberStrategyId) {
        this.memberStrategyId = memberStrategyId;
    }

    public String getMemberStrategyName() {
        return memberStrategyName;
    }

    public void setMemberStrategyName(String memberStrategyName) {
        this.memberStrategyName = memberStrategyName;
    }

    public String getMemberPictureUrl() {
        return memberPictureUrl;
    }

    public void setMemberPictureUrl(String memberPictureUrl) {
        this.memberPictureUrl = memberPictureUrl;
    }

    public Integer getPurchaseThreshold() {
        return purchaseThreshold;
    }

    public void setPurchaseThreshold(Integer purchaseThreshold) {
        this.purchaseThreshold = purchaseThreshold;
    }

    public Double getMemberDiscountRate() {
        return memberDiscountRate;
    }

    public void setMemberDiscountRate(Double memberDiscountRate) {
        this.memberDiscountRate = memberDiscountRate;
    }
}
