package org.seec.muggle.auror.vo.strategy.refund;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:48
 * @Version 1.0
 **/
public class RefundStrategyVO {
    String latestRefundTimeBeforePaying; //距离开场的时间
    String refundRate;

    public String getLatestRefundTimeBeforePaying() {
        return latestRefundTimeBeforePaying;
    }

    public void setLatestRefundTimeBeforePaying(String latestRefundTimeBeforePaying) {
        this.latestRefundTimeBeforePaying = latestRefundTimeBeforePaying;
    }

    public String getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(String refundRate) {
        this.refundRate = refundRate;
    }
}
