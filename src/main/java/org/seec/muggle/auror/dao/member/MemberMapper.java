package org.seec.muggle.auror.dao.member;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.MemberPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:57
 * @Version 1.0
 **/
@DaoMapper
public interface MemberMapper {

    MemberPO getMemberById(@Param("userId") Long userId);

    int updateMemberById(@Param("userId")Long userId,@Param("strategyId")Long strategyId);

    int updateCredit(@Param("cost")Integer credit,@Param("userId")Long userId);

}
