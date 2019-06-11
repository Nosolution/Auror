package org.seec.muggle.auror.vo;

import org.seec.muggle.auror.util.DateUtil;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/31 11:36
 * @Version 1.0
 **/
public class IntervalVO {
    String startTime;
    String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public IntervalVO(Timestamp startTime, Timestamp endTime) {

        this.startTime = DateUtil.timestampToTimeString(startTime);
        this.endTime = DateUtil.timestampToTimeString(endTime);
    }
}
