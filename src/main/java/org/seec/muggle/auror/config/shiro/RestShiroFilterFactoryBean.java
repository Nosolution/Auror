package org.seec.muggle.auror.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.BeanInitializationException;

/**
 * 实现REST风格到方法粒度的url链的逻辑判断
 * 使用继承覆盖父类行为
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/20
 */
public class RestShiroFilterFactoryBean extends ShiroFilterFactoryBean {
//    private static final Logger log = LoggerFactory.getLogger(RestShiroFilterFactoryBean.class);

    @Override
    protected AbstractShiroFilter createInstance() {

//        log.debug("Creating Shiro Filter instance.");

        SecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            String msg = "SecurityManager property must be set.";
            throw new BeanInitializationException(msg);
        }

        if (!(securityManager instanceof WebSecurityManager)) {
            String msg = "The security manager does not implement the WebSecurityManager interface.";
            throw new BeanInitializationException(msg);
        }

        FilterChainManager manager = createFilterChainManager();


        PathMatchingFilterChainResolver chainResolver = new RestPathMatchingFilterChainResolver();
        chainResolver.setFilterChainManager(manager);


        return new SpringShiroFilter((WebSecurityManager) securityManager, chainResolver);
    }

    private static final class SpringShiroFilter extends AbstractShiroFilter {
        protected SpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
            super();
            if (webSecurityManager == null) {
                throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
            }
            setSecurityManager(webSecurityManager);
            if (resolver != null) {
                setFilterChainResolver(resolver);
            }
        }
    }
}
