package org.seec.muggle.auror.vo.strategy.member;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:14
 * @Version 1.0
 **/
public class MemberAddForm {
    String memberStrategyName; // 约等于会员卡等级
    String memberPictureurl;
    Integer purchaseThreshold;
    Double memberDiscountRate;

    public String getMemberStrategyName() {
        return memberStrategyName;
    }

    public void setMemberStrategyName(String memberStrategyName) {
        this.memberStrategyName = memberStrategyName;
    }

    public String getMemberPictureurl() {
        return memberPictureurl;
    }

    public void setMemberPictureurl(String memberPictureurl) {
        this.memberPictureurl = memberPictureurl;
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
