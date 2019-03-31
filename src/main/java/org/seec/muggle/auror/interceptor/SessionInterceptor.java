package org.seec.muggle.auror.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author huwen
 * @date 2019/3/23
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
    //因为开启后在本地无页面测试会报错，因此关掉了
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
//        HttpSession session = httpServletRequest.getSession();
//        if (null != session && null != session.getAttribute(InterceptorConfiguration.SESSION_KEY)) {
//            return true;
//        }
//        httpServletResponse.sendRedirect("/index");
//        return false;
//    }

}
