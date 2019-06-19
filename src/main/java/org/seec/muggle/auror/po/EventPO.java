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
    //优惠活动id
    Long id;
    //开始时间
    Timestamp startTime;
    //结束时间
    Timestamp endTime;
    //活动描述
    String description;
    //活动名称
    String eventName;
    //优惠券的有效期长度，单位：天
    Integer expiration;
    //优惠券模板id
    Long couponId;

    public EventPO() {

    }

    public EventPO(Timestamp startTime, Timestamp endTime, String description, String eventName, Integer expiration) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.eventName = eventName;
        this.expiration = expiration;
    }
}
