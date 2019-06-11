package org.seec.muggle.auror.vo.order.recharge_history;

import org.seec.muggle.auror.util.DateUtil;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:27
 * @Version 1.0
 **/
public class RechargeHistoryVO {
    String time;
    Integer cost;

    public String getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = DateUtil.timestampToString(time);
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
