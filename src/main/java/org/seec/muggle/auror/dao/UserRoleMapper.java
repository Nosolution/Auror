package org.seec.muggle.auror.dao;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.entity.UserRole;

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
}
