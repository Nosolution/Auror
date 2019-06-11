package org.seec.muggle.auror.vo.strategy.event;

import lombok.Data;
import org.seec.muggle.auror.po.CouponPO;
import org.seec.muggle.auror.po.EventPO;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:14
 * @Version 1.0
 **/
@Data
public class EventVO {
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
    String couponExpiration;

    public EventVO(EventPO eventPO, CouponPO couponPO, List<Long> movies){
        this.eventId = eventPO.getId();
        this.eventName = eventPO.getEventName();
        this.eventDescription = eventPO.getDescription();
        this.moviesIncluded = movies.toArray(new Long[movies.size()]);
        this.startTime = eventPO.getStartTime();
        this.endTime = eventPO.getEndTime();
        this.couponName = couponPO.getCouponName();
        this.couponDescription = couponPO.getDescription();
        this.couponPictureUrl = couponPO.getUrl();
        this.couponDiscount = couponPO.getDiscount();
        this.couponThreshold = couponPO.getThreshold();
        this.couponExpiration = "";

    }


}
