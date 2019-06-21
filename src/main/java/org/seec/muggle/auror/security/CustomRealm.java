package org.seec.muggle.auror.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.seec.muggle.auror.dataservice.account.UserMapper;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.Permission;
import org.seec.muggle.auror.po.Role;
import org.seec.muggle.auror.po.User;
import org.seec.muggle.auror.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * 自定义realm，负责根据token进行鉴权
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/2
 */
@Service
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserMapper userMapper;

    /**
     * 在需要检验用户权限的时候调用。比如在访问某些接口时
     *
     * @param principals 用户名，在此即为token本身
     * @return 包含用户角色与权限的认证信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //这里的username实际为id
        Long id = jwtUtil.getIdFromToken(principals.toString());
        User user = userMapper.get(id);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList()));
        //shiro有permission的接口，晚点再看看能不能用
        simpleAuthorizationInfo.addStringPermissions(user.getPermissions()
                .stream()
                .map(Permission::getName)
                .collect(Collectors.toList()));
        return simpleAuthorizationInfo;

    }

    /**
     * @param token 需被检验的token
     * @return {@code true}如果 token 是JwtToken类的实例，否则为{@code false}
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        //不知如果JwtToken不继承shiro自带的AuthenticationToken会怎么样
        return token instanceof JwtToken;
    }

    /**
     * 在需要检验token正确性即需要登录时调用。
     *
     * @param authenticationToken 需被检验的token
     * @return 认证信息
     * @throws BaseException 认证失败异常，状态码{@code 401}
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws BaseException {
        String token = (String) authenticationToken.getPrincipal();
        Long id = jwtUtil.getIdFromToken(token);
        //这里使用原来的mapper与实体User，以后可能会需要更改
        //如果user找不到，应该抛出一个异常
        User user = userMapper.get(id);
        //认证失败应该抛出一个异常，因项目还未完善，暂不处理
        if (!jwtUtil.validateToken(token, user))
            throw new AuthenticationException("Username or password error");

        //参考代码的返回写法是这样，还有待研究
        return new SimpleAuthenticationInfo(token, token, "custom_realm");
    }
}
