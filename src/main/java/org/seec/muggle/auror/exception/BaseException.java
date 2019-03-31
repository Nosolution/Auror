package org.seec.muggle.auror.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

/**
 * 异常基类，通过HttpStatus与message构造
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/6
 */
public class BaseException extends RuntimeException {
    @JsonIgnore
    private HttpStatus status;

    public BaseException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
