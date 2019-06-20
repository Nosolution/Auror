package org.seec.muggle.auror.exception;

import lombok.Data;

/**
 * 错误详情类
 * 在请求出错时使用
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/3/31
 */
@Data
public class ErrorDetail {
    private String error;
    private String message;

    public ErrorDetail(String error, String message) {
        this.error = error;
        this.message = message;
    }

}
