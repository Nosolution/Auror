package org.seec.muggle.auror.dao.manager;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.User;

import java.util.List;

/**
 * 排片经理相关的数据接口
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/19
 */
@DaoMapper
public interface ManagerMapper {

    List<User> getManagers();

    List<Long> getAdminIds();

    int addNewManager(User user);

    int addRole(Long managerId);

    int deleteManager(Long managerId);

    int deleteRole(Long managerId);


}
