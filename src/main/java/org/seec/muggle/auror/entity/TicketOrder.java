package org.seec.muggle.auror.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购票订单
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class TicketOrder {
    //订单id
    private Long id;
    //用户id
    private Long userId;
    //场次id
    private Long sceneId;
    //创建时间
    private Date time;
    //座位号
    private String seat;
    //支付金额
    private BigDecimal payment;
    //状态
    private String status;
    //采用的折扣策略
    private String discountStrategy;
}
