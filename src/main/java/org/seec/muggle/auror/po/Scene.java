package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 场次类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class Scene {
    //场次id
    private Long id;
    //电影id
    private Long movieId;
    //影厅id
    private Long hallId;
    //电影版本
    private String movieVersion;
    //开始时间
    private Timestamp startTime;
    //结束时间
    private Timestamp endTime;
    //价格
    private BigDecimal price;
    //观众可见日期
    private Date showTime;
    //所有座位 0: 不可用， 1:可用且可选 2:可用但不可选
    private Integer[][] seats;
}
