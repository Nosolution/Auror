package org.seec.muggle.auror.entity;


import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Permission> permissions;
    private Timestamp lastLogoutTime;
    private Timestamp lastPasswordResetTime;


    /**
     * 注册用户时使用，产生新的用户实体
     *
     * @param username 用户名
     * @param password 明文密码
     * @return 各字段设置好的实例(不包括角色与权限)
     */
    public static User generateNerUser(String username, String password) {
        User u = new User();
        u.setUsername(username);
        //这里使用独立的jBCrypt包而不是shiro内置的加密器加密，因为之前用的就是BCrypt
        String passwordEncrypted = BCrypt.hashpw(password, BCrypt.gensalt());
        u.setPassword(passwordEncrypted);
        u.setLastLogoutTime(new Timestamp(new Date().getTime()));
        u.setLastPasswordResetTime(new Timestamp(new Date().getTime()));
        return u;
    }

}
