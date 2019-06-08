package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 21:43
 * @Version 1.0
 **/
public class Member4Account {
    boolean isMember;
    Integer memberCredit;


    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public Integer getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(Integer memberCredit) {
        this.memberCredit = memberCredit;
    }

}
