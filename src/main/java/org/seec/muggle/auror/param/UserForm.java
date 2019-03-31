package org.seec.muggle.auror.param;

/**
 * 用户表单信息
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/11
 */
public class UserForm {
    /**
     * 用户名，不可重复
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
