package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 优惠券策略
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class Event {
    //策略id
    private Long id;
    //名称
    private String name;
    //描述
    private String description;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //优惠额度
    private BigDecimal credit;
    //参加条件
    private String participatingCondition;
    //参加活动的电影
    private List<Long> movieIncluded;
}
