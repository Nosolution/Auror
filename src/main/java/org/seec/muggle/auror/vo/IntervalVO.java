package org.seec.muggle.auror.vo;

import java.time.LocalTime;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/31 11:36
 * @Version 1.0
 **/
public class IntervalVO {
    LocalTime startTime;
    LocalTime endTime;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
