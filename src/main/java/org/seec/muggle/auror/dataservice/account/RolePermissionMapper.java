package org.seec.muggle.auror.dataservice.account;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dataservice.BaseOperation;
import org.seec.muggle.auror.po.RolePermission;

import java.util.List;

/**
 * role_permission表操作类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/11
 */
@DaoMapper
public interface RolePermissionMapper extends BaseOperation<RolePermission> {
    int insertBatch(List<RolePermission> items);
}
