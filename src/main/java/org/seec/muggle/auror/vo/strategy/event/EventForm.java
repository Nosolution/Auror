package org.seec.muggle.auror.vo.strategy.event;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:07
 * @Version 1.0
 **/
@Data
public class EventForm {
    Long eventId;
    String eventName;
    String eventDescription;
    Long[] moviesIncluded ;
    Timestamp startTime;
    Timestamp endTime;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Integer couponDiscount;
    Integer couponThreshold;
    Integer couponExpiration;


}
