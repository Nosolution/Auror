package org.seec.muggle.auror.vo.order.recharge;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:25
 * @Version 1.0
 **/
public class RechargeVO {
    Integer credit;//余额
    boolean isUpgraded; // 此次充值是否使会员卡升级
    String newMemberStrategyName;
    String newMemberPictureUrl;
    Double newMemberDiscountRate;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public boolean isUpgraded() {
        return isUpgraded;
    }

    public void setUpgraded(boolean upgraded) {
        isUpgraded = upgraded;
    }

    public String getNewMemberStrategyName() {
        return newMemberStrategyName;
    }

    public void setNewMemberStrategyName(String newMemberStrategyName) {
        this.newMemberStrategyName = newMemberStrategyName;
    }

    public String getNewMemberPictureUrl() {
        return newMemberPictureUrl;
    }

    public void setNewMemberPictureUrl(String newMemberPictureUrl) {
        this.newMemberPictureUrl = newMemberPictureUrl;
    }

    public Double getNewMemberDiscountRate() {
        return newMemberDiscountRate;
    }

    public void setNewMemberDiscountRate(Double newMemberDiscountRate) {
        this.newMemberDiscountRate = newMemberDiscountRate;
    }
}
