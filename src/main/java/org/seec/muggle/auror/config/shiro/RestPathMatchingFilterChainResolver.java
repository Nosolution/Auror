package org.seec.muggle.auror.config.shiro;

import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 实现REST风格到方法粒度的url链的逻辑判断
 * 使用继承覆盖父类行为
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/20
 */
public class RestPathMatchingFilterChainResolver extends PathMatchingFilterChainResolver {

//    private static final Logger log = LoggerFactory.getLogger(RestPathMatchingFilterChainResolver.class);

    @Override
    public FilterChain getChain(ServletRequest request, ServletResponse response, FilterChain originalChain) {
        FilterChainManager filterChainManager = getFilterChainManager();
        if (!filterChainManager.hasChains()) {
            return null;
        }

        String requestURI = getPathWithinApplication(request);
        for (String pathPattern : filterChainManager.getChainNames()) {
            String[] pathPatternArray = pathPattern.split("==");

            // 只用过滤器链的 URL 部分与请求的 URL 进行匹配
            if (pathMatches(pathPatternArray[0], requestURI)) {
//                if (log.isTraceEnabled()) {
//                    log.trace("Matched path pattern [" + pathPattern + "] for requestURI [" + requestURI + "].  " +
//                            "Utilizing corresponding filter chain...");
//                }
                return filterChainManager.proxy(originalChain, pathPattern);
            }
        }

        return null;
    }
}
