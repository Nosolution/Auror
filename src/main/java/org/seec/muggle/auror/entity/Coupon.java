package org.seec.muggle.auror.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    //优惠策略id
    private Long strategyId;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //优惠券金额
    private BigDecimal benefitCredit;

}
