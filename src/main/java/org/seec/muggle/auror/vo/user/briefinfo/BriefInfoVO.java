package org.seec.muggle.auror.vo.user.briefinfo;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:23
 * @Version 1.0
 **/
public class BriefInfoVO {
    Long userId;
    Integer userTotalConsumption;//用户累计消费
    boolean isMember; //是否是会员
    Integer memberCredit;//会员卡余额

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserTotalConsumption() {
        return userTotalConsumption;
    }

    public void setUserTotalConsumption(Integer userTotalConsumption) {
        this.userTotalConsumption = userTotalConsumption;
    }

    public boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(boolean member) {
        isMember = member;
    }

    public Integer getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(Integer memberCredit) {
        this.memberCredit = memberCredit;
    }
}
