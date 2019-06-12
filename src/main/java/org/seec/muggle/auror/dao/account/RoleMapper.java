package org.seec.muggle.auror.dao.account;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dao.BaseOperation;
import org.seec.muggle.auror.po.Role;

import java.util.List;

/**
 * 实体Role映射类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/6
 */
@DaoMapper
public interface RoleMapper extends BaseOperation<Role> {

    List<Role> getRolesByUserId(Long id);

    Role getRoleByName(@Param("name") String name);

}
