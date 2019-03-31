package org.seec.muggle.auror.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 用户心仪电影的记录
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/6
 */
@Data
@NoArgsConstructor
public class FavoriteRecord {
    private Integer id;
    private Integer movieId;
    private Integer userId;
    private Timestamp time;
}
