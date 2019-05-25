package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户心仪电影的记录
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/6
 */
@Data
public class FavoriteRecord {
    private Integer id;
    private Integer movieId;
    private Integer userId;
    private Timestamp time;
}
