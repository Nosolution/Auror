package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
    private Timestamp initTime;
    //影票数目
    private int ticketNum;
    //座位号列表
    private String seats; // "<row>:<column>,<row>:<column>" 比如"1:2,1,3"
    //支付金额
    private BigDecimal cost;
    //状态
    private String status; //0: 未完成 1: 已完成 2: 已失效
    //取票码
    private String ticketCode;

}
