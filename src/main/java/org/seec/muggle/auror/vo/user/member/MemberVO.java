package org.seec.muggle.auror.vo.user.member;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:51
 * @Version 1.0
 **/
public class MemberVO {
    Long memberId;
    String memberStrategyName; // 约等于会员卡等级
    String memberPictureurl;
    Integer memberCredit;
    Integer memberDiscount;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

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

    public Integer getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(Integer memberCredit) {
        this.memberCredit = memberCredit;
    }

    public Integer getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Integer memberDiscount) {
        this.memberDiscount = memberDiscount;
    }
}
