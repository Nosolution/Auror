package org.seec.muggle.auror.po;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 21:23
 * @Version 1.0
 **/
public class EventPO {
    Long id;
    Timestamp startTime;
    Timestamp endTime;
    String description;
    String eventName;

    Long couponId;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventPO(){

    }

    public EventPO(Timestamp startTime, Timestamp endTime, String description, String eventName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.eventName = eventName;
    }
}
