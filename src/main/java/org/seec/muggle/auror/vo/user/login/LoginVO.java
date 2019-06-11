package org.seec.muggle.auror.vo.user.login;

import lombok.Data;
import org.seec.muggle.auror.enums.UserRoleEnum;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/28 20:40
 * @Version 1.0
 **/
@Data
public class LoginVO {
    String role;
    String token;

    public LoginVO(UserRoleEnum role, String token) {
        this.role = role.toString();
        this.token = token;
    }
    public LoginVO(){

    }
}
