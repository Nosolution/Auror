package org.seec.muggle.auror.po;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 18:56
 * @Version 1.0
 **/
public class UserCouponPO {
    Long id;
    Long couponId;
    Long userId;
    Date start;
    Date end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
