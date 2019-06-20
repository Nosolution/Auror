package org.seec.muggle.auror.advice;

import org.apache.shiro.authz.UnauthorizedException;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.exception.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/3/31
 */
@RestControllerAdvice
public class GlobalAdvice {
    /**
     * 所有失败请求的响应的出口
     *
     * @param ex 待处理的BaseException类，代表某个请求在预设范围内失败了
     * @return 状态码为非200的响应
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDetail("exception", ex.getMessage()));
    }

    /**
     * 访问接口所需权限不足时转至该接口，返回状态码403
     *
     * @param ex 鉴权失败时抛出的异常
     * @return 状态码为403的响应
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(UnauthorizedException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorDetail("exception", ex.getMessage()));
    }

    /**
     * 一般性的异常处理器
     *
     * @param ex 未预知的异常
     * @return 状态码为500的响应，带有异常message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
//        if (ex instanceof UnauthorizedException)
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorDetail("exception", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDetail("exception", ex.getMessage()));
    }
}
