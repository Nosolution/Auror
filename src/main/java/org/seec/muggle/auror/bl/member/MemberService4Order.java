package org.seec.muggle.auror.bl.member;

import org.seec.muggle.auror.po.MemberPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 19:48
 * @Version 1.0
 **/
public interface MemberService4Order {
    MemberPO getMemberByUserId(Long userId);

    public void changeStrategy(Long userId,Long strategyId);

    public void recharge(Integer cost,Long userId);

    Integer payByMember(Integer cost, Long userId);
}
