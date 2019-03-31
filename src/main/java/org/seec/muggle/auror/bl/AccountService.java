package org.seec.muggle.auror.bl;

import org.seec.muggle.auror.dao.User;
import org.seec.muggle.auror.param.UserForm;

public interface AccountService {

    /**
     * 注册账号
     * @return
     */
    public String registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     * @return
     */
    public User login(UserForm userForm);

}

