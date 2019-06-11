package org.seec.muggle.auror.vo.strategy.refund;

import lombok.Data;
import org.seec.muggle.auror.po.RefundPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:48
 * @Version 1.0
 **/
@Data
public class RefundStrategyVO {
    Integer latestRefundTimeBeforePaying; //距离开场的时间
    Double refundRate;


    public RefundStrategyVO(RefundPO po){
        this.latestRefundTimeBeforePaying = po.getBeforeTime();
        this.refundRate = po.getRate();
    }
}
