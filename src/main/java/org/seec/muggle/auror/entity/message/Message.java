package org.seec.muggle.auror.entity.message;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 为message模块提供的message信息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/19
 */
@Data
public class Message {
    private Long userId;
    private Integer type;
    private String title;
    private String content;
    private Timestamp initTime;
    private Integer status;
    private Long additionalMovieId;
}
