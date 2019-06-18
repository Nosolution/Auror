package org.seec.muggle.auror.dao.account;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dao.BaseOperation;
import org.seec.muggle.auror.po.UserRole;

import java.util.List;

/**
 * user_role表的操作类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/11
 */
@DaoMapper
public interface UserRoleMapper extends BaseOperation<UserRole> {

    int insertBatch(List<UserRole> items);

    int deleteByUserId(@Param("userId") Long userId);

    List<Long> getAllManagerId();

    List<Long> getAllUserId();
}
