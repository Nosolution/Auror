package org.seec.muggle.auror.bl;

import org.seec.muggle.auror.vo.UserForm;

public interface AccountService {

    /**
     * 注册账号
     *
     * @param userForm 注册表单
     */
    public void registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会返回token
     *
     * @return token
     */
    public String login(UserForm userForm);

    /**
     * 退出登录
     *
     * @param token header中带有的token(未截取子串)
     */
    public void logout(String token);

}

