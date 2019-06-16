package org.seec.muggle.auror.bl.member;

import org.seec.muggle.auror.vo.user.member.MemberVO;

/**
 * @Description 业务逻辑层member模块接口
 * @Author 233loser
 * @Date 2019/6/7 16:54
 * @Version 1.0
 **/
public interface MemberService {
    /**
     * 获取个人会员信息
     *
     * @param userId 用户id
     * @return 会员信息
     */
    MemberVO getPersonalMemberInfo(Long userId);
}
