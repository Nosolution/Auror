package org.seec.muggle.auror.vo.strategy.refund;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:49
 * @Version 1.0
 **/
@Data
public class RefundStrategyForm {
    Integer latestRefundTimeBeforePlaying; //距离开场的时间
    Double refundRate;

}
