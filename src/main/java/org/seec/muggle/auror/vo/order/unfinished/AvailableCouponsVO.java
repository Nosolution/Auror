package org.seec.muggle.auror.vo.order.unfinished;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:44
 * @Version 1.0
 **/
public class AvailableCouponsVO {
    Long couponId;
    String couponName;
    Integer discount;
    Date endTime;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public AvailableCouponsVO(Long couponId, String couponName, Integer discount, Date endTime) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.discount = discount;
        this.endTime = endTime;
    }
}
