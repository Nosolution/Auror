package org.seec.muggle.auror.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 符合jwt规范的token类，实现shiro的token接口以使用shiro的服务
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/2
 */

public class JwtToken implements AuthenticationToken {
    /**
     * 不使用shiro的标准用法，而是使用本身已被加密的字符串，本身已带有各种信息(没有密码)，使用JwtUtil类进行解码
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        //直接返回token本身
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
