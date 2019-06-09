package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 21:23
 * @Version 1.0
 **/
@Data
public class EventPO {
    Long id;
    Timestamp startTime;
    Timestamp endTime;
    String description;
    String eventName;
    Integer expiration;

    Long couponId;

    public EventPO() {

    }

    public EventPO(Timestamp startTime, Timestamp endTime, String description, String eventName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.eventName = eventName;
    }
}
