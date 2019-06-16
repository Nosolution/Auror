package org.seec.muggle.auror.advice;

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
     * 一般性的异常处理器
     *
     * @param ex 未预知的异常
     * @return 状态码为500的响应，带有异常message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDetail("exception", ex.getMessage()));
    }
}
