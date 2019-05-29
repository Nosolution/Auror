package org.seec.muggle.auror.vo.strategy.coupon_gift;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:26
 * @Version 1.0
 **/
public class CouponGiftForm {
    UserIdForm[] userList;
    String startTime;
    String endTime;
    String couponName;
    String couponDescription;
    String couponPictureUrl;
    Integer couponDiscount;// 金额
    Integer couponThreshold; //优惠券使用门槛
    String couponExpiration;

    public UserIdForm[] getUserList() {
        return userList;
    }

    public void setUserList(UserIdForm[] userList) {
        this.userList = userList;
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

    public String getCouponExpiration() {
        return couponExpiration;
    }

    public void setCouponExpiration(String couponExpiration) {
        this.couponExpiration = couponExpiration;
    }
}
