package org.seec.muggle.auror.vo.user.login;

import org.seec.muggle.auror.enums.UserRoleEnum;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/28 20:40
 * @Version 1.0
 **/
public class LoginVO {
    String role;
    String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginVO(UserRoleEnum role, String token) {
        this.role = role.toString();
        this.token = token;
    }
    public LoginVO(){

    }
}
