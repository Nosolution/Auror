package org.seec.muggle.auror.vo.user.coupon;

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
    String couponDiscound;
    Integer couponThreshold; //使用门槛
    String couponStartTime;
    String couponEndTime;
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

    public String getCouponDiscound() {
        return couponDiscound;
    }

    public void setCouponDiscound(String couponDiscound) {
        this.couponDiscound = couponDiscound;
    }

    public Integer getCouponThreshold() {
        return couponThreshold;
    }

    public void setCouponThreshold(Integer couponThreshold) {
        this.couponThreshold = couponThreshold;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponExpiration() {
        return couponExpiration;
    }

    public void setCouponExpiration(String couponExpiration) {
        this.couponExpiration = couponExpiration;
    }
}
