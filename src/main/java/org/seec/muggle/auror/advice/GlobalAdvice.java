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
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDetail("exception", ex.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDetail("exception", ex.getMessage()));
    }
}
