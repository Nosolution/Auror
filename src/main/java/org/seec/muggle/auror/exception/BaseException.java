package org.seec.muggle.auror.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

/**
 * 异常基类，通过HttpStatus与message构造
 * 可在请求失败时自定义状态码与错误信息最终抛出，削除了controller层判断service层是否成功的冗余代码
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
