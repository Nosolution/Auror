package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 电影评论
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/5/12
 */
@Data
public class Comment {
    private Long id;
    private Long userId;
    private Long movieId;
    private Double score;
    private String content;
    private Timestamp initTime;
}
