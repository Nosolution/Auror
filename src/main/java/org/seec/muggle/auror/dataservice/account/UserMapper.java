package org.seec.muggle.auror.dataservice.account;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dataservice.BaseOperation;
import org.seec.muggle.auror.po.User;

/**
 * @author huwen
 * @date 2019/3/23
 */
@DaoMapper
public interface UserMapper extends BaseOperation<User> {

    /**
     * 根据用户名查找账号
     *
     * @param username 用户名
     * @return 根据用户名查找到的User实例
     */
    public User getUserByName(@Param("username") String username);

    public int deleteUserById(@Param("userId") Long userId);

    public User getUserById(@Param("userId") Long userId);

}
