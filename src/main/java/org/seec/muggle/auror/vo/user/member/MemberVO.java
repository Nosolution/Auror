package org.seec.muggle.auror.vo.user.member;

import lombok.Data;
import org.seec.muggle.auror.entity.strategy.MemberStrategy4Member;
import org.seec.muggle.auror.po.MemberPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:51
 * @Version 1.0
 **/
@Data
public class MemberVO {
    boolean isMember;
    Long memberId;
    String memberStrategyName; // 约等于会员卡等级
    String memberPictureUrl;
    Integer memberCredit;
    Double memberDiscount;

    public boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(boolean member) {
        isMember = member;
    }

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

    public String getMemberPictureUrl() {
        return memberPictureUrl;
    }

    public void setMemberPictureUrl(String memberPictureUrl) {
        this.memberPictureUrl = memberPictureUrl;
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


    public MemberVO() {

    }

    public MemberVO(MemberPO memberPO, MemberStrategy4Member strategyPO) {
        this.memberCredit = memberPO.getCredit();
        this.memberDiscount = strategyPO.getRate();
        this.memberId = memberPO.getId();
        this.memberPictureUrl = strategyPO.getUrl();
        this.memberStrategyName = strategyPO.getName();
    }
}
