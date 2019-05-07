package org.seec.muggle.auror.entity;

import lombok.Data;

import java.math.BigDecimal;
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
    private Date startTime;
    //结束时间
    private Date endTime;
    //加个
    private BigDecimal price;
    //观众可见时间
    private Date showTime;
    //所有座位
    private Integer[][] seats;
    //可用座位
    private Integer[][] seatsAvailable;
}
