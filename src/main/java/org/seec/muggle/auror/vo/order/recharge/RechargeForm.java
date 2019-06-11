package org.seec.muggle.auror.vo.order.recharge;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:22
 * @Version 1.0
 **/
@Data
public class RechargeForm {
    Long memberId;
    Integer cost; // 充值金额
}
