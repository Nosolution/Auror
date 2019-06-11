package org.seec.muggle.auror.vo.user.member;

import org.seec.muggle.auror.po.MemberPO;
import org.seec.muggle.auror.po.MemberStrategyPO;

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
    Double memberDiscount;

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

    public Double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public MemberVO(MemberPO memberPO, MemberStrategyPO strategyPO){
        this.memberCredit = memberPO.getCredit();
        this.memberDiscount = strategyPO.getRate();
        this.memberId = memberPO.getId();
        this.memberPictureurl = strategyPO.getUrl();
        this.memberStrategyName = strategyPO.getName();
    }
}
