package org.seec.muggle.auror.filter;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.security.JwtToken;
import org.seec.muggle.auror.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对request进行过滤，根据业务逻辑实现相应的过滤策略
 * 默认替换{@link BasicHttpAuthenticationFilter}:authcBasic
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/2
 */
public class JwtAuthTokenFilter extends BasicHttpAuthenticationFilter {
    /**
     * 这里继承{@link BasicHttpAuthenticationFilter} 而不是 {@link FormAuthenticationFilter}。
     * 两者都要求用户登录，区别在于，前者使用 {@code HTTP Basic protocol-specific challenge} 来进行登录验证, 后者会重定向至登录url
     */
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JwtUtil jwtUtil;

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    /**
     * 每次有request的时候进行token鉴权
     *
     * @param request  客户端发送的request
     * @param response 还不知道干什么用
     * @return token鉴权结果
     * @throws Exception 未知exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");

        if (authorization.length() <= 7)
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "token错误");
        JwtToken token = new JwtToken(authorization.substring(7));
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 这里我们详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     *
     * 实际上这里不应该这么做, 而是使用注解或者url配置来完成登录与否的鉴别
     * 或者在{@link onAccessDenied()}方法里写?
     */
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if (isLoginAttempt(request, response)) {
//            try {
//                executeLogin(request, response);
//            } catch (Exception e) {
//                response401(request, response);
//            }
//        }
//        return true;
//    }

//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        return super.onAccessDenied(request, response);
//    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            //不继续再filterChain中传递
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean pathsMatch(String path, ServletRequest request) {
        return super.pathsMatch(path, request);
    }

    /**
     * 将非法请求跳转到 /401
     */
    private void response401(ServletRequest request, ServletResponse response) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("/401");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
