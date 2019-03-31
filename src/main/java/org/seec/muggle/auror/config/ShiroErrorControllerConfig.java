package org.seec.muggle.auror.config;

import org.seec.muggle.auror.advice.ShiroErrorController;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 配置，使{@link ShiroErrorController}实例可被注入
 *
 * @author Nosolution
 * @version 1.0
 * @see ShiroErrorController
 * @since 2019/4/12
 */
@Configuration
//@ConditionalOnWebApplication
//@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
//@AutoConfigureBefore(WebMvcAutoConfiguration.class)
//@EnableConfigurationProperties(ResourceProperties.class)
public class ShiroErrorControllerConfig {

    private final ServerProperties serverProperties;

    private final List<ErrorViewResolver> errorViewResolvers;

    public ShiroErrorControllerConfig(ServerProperties serverProperties,
                                      ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        this.serverProperties = serverProperties;
        this.errorViewResolvers = errorViewResolversProvider.getIfAvailable();
    }

    @Bean
//    @ConditionalOnMissingBean(value = ErrorController.class, search = SearchStrategy.CURRENT)
    public ShiroErrorController shiroErrorController(ErrorAttributes errorAttributes) {
        return new ShiroErrorController(errorAttributes,
                this.serverProperties.getError(),
                this.errorViewResolvers);

    }
}
