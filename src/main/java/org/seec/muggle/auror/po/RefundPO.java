package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:13
 * @Version 1.0
 **/
public class RefundPO {
    Integer beforeTime;
    String description;
    Double rate;

    public Integer getBeforeTime() {
        return beforeTime;
    }

    public void setBeforeTime(Integer beforeTime) {
        this.beforeTime = beforeTime;
    }

    public String getDescription() {
        return description;
    }

    public RefundPO(Integer beforeTime, Double rate) {
        this.beforeTime = beforeTime;
        this.rate = rate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    public RefundPO(){

    }
}
