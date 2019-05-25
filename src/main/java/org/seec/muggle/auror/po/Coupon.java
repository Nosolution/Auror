package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 优惠券类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class Coupon {
    //优惠券id
    private Long id;
    //用户id
    private Integer userId;
    //优惠券名称
    private String name;
    //优惠券描述
    private String description;
    //图片url
    private String pictureUrl;
    //优惠活动id
    private Long eventId;
    //开始时间
    private Timestamp startTime;
    //结束时间
    private Timestamp endTime;
    //有效期长度
    private Integer expiration; //单位:天数
    //使用门槛
    private BigDecimal threshold;
    //优惠券金额
    private BigDecimal discount;


}
