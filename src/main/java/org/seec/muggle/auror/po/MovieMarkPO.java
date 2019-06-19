package org.seec.muggle.auror.po;

import lombok.Data;

import java.util.Date;

/**
 * 用户心仪电影的记录
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/6
 */
@Data
public class MovieMarkPO {
    private Long movieId;
    //用户id
    private Long userId;
    //标记的日期
    private Date time;
}
