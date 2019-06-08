package org.seec.muggle.auror.bl.member;

import org.seec.muggle.auror.vo.user.member.MemberVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:54
 * @Version 1.0
 **/
public interface MemberService {
    public MemberVO getPersonalMemberInfo(Long userId);
}
