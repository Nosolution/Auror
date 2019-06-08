package org.seec.muggle.auror.vo.user.coupon;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:04
 * @Version 1.0
 **/
public class UserCouponsVO {
    Long couponId;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Integer couponDiscount;
    Integer couponThreshold; //使用门槛
    Date couponStartTime;
    Date couponEndTime;
    String couponExpiration; //有效期长度

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

    public Integer getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Integer couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Integer getCouponThreshold() {
        return couponThreshold;
    }

    public void setCouponThreshold(Integer couponThreshold) {
        this.couponThreshold = couponThreshold;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponExpiration() {
        return couponExpiration;
    }

    public void setCouponExpiration(String couponExpiration) {
        this.couponExpiration = couponExpiration;
    }
}
