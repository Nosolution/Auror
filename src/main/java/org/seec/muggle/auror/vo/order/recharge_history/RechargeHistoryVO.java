package org.seec.muggle.auror.vo.order.recharge_history;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:27
 * @Version 1.0
 **/
public class RechargeHistoryVO {
    Timestamp time;
    Integer cost;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
