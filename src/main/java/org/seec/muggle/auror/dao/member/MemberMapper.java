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

    MemberPO selectMemberById(@Param("userId")Long userId);

}
