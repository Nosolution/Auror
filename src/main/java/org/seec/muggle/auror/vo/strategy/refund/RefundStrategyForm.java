package org.seec.muggle.auror.vo.strategy.refund;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:49
 * @Version 1.0
 **/
public class RefundStrategyForm {
    Integer latestRefundTimeBeforePaying; //距离开场的时间
    Double refundRate;

    public Integer getLatestRefundTimeBeforePaying() {
        return latestRefundTimeBeforePaying;
    }

    public void setLatestRefundTimeBeforePaying(Integer latestRefundTimeBeforePaying) {
        this.latestRefundTimeBeforePaying = latestRefundTimeBeforePaying;
    }

    public Double getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(Double refundRate) {
        this.refundRate = refundRate;
    }
}
