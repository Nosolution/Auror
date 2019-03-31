package org.seec.muggle.auror.advice;

import org.apache.shiro.ShiroException;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * shiro抛出异常的处理类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/12
 */
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ShiroErrorController extends BasicErrorController {

    public ShiroErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Throwable e = exception;//第一层基本都是ServletException, 解除装饰
        while (e instanceof ServletException && e.getCause() != null) {
            e = e.getCause();
        }
        //此处可以再细化为不同的ShiroException
        if (e instanceof ShiroException) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", e.getClass());
            res.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
        }
        return super.error(request);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
