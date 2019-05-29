package org.seec.muggle.auror.vo.strategy.event;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:07
 * @Version 1.0
 **/
public class EventForm {
    Long eventId;
    String eventName;
    String eventDescription;
    MovieIdForm[] moviesIncluded ;
    String startTime;
    String endTime;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Double couponDiscount;
    Integer couponThreshold;
    String couponExpiration;


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public MovieIdForm[] getMoviesIncluded() {
        return moviesIncluded;
    }

    public void setMoviesIncluded(MovieIdForm[] moviesIncluded) {
        this.moviesIncluded = moviesIncluded;
    }

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

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getCouponPictureUrl() {
        return couponPictureUrl;
    }

    public void setCouponPictureUrl(String couponPictureUrl) {
        this.couponPictureUrl = couponPictureUrl;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Integer getCouponThreshold() {
        return couponThreshold;
    }

    public void setCouponThreshold(Integer couponThreshold) {
        this.couponThreshold = couponThreshold;
    }

    public String getCouponExpiration() {
        return couponExpiration;
    }

    public void setCouponExpiration(String couponExpiration) {
        this.couponExpiration = couponExpiration;
    }
}
