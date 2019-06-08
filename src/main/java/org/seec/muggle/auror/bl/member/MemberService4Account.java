package org.seec.muggle.auror.bl.member;

import org.seec.muggle.auror.po.Member4Account;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 21:46
 * @Version 1.0
 **/
public interface MemberService4Account {
    Member4Account getMemberByUser(Long userid);
}
