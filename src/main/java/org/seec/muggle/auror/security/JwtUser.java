package org.seec.muggle.auror.security;

import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

/**
 * 在鉴权中使用的User类，用于安全需求
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/3
 */
@Data
public class JwtUser {
    @NonNull
    private String username;
    private String password;
    @NonNull
    private Timestamp lastLogoutTime;
    @NonNull
    private Timestamp lastPasswordResetTime;

}
