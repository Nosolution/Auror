package org.seec.muggle.auror.bl.member;


import org.seec.muggle.auror.entity.member.MemberAccount;

/**
 * @Description member模块为account模块提供的接口
 * @Author 233loser
 * @Date 2019/6/8 21:46
 * @Version 1.0
 **/
public interface MemberService4Account {

    /**
     * 获取用户的会员账户信息
     *
     * @param userId 用户id
     * @return 会员账户信息
     */
    MemberAccount getMemberByUser(Long userId);
}
