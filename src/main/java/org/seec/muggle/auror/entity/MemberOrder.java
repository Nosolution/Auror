package org.seec.muggle.auror.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员充值订单
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class MemberOrder {
    //订单id
    private Long id;
    //用户id
    private Long userId;
    //会员id
    private Long memberId;
    //创建时间
    private Date time;
    //支付金额
    private BigDecimal payment;
    //支付状态
    private String status;
}
