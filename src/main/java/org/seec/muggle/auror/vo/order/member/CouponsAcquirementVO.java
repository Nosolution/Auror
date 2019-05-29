package org.seec.muggle.auror.vo.order.ticket;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:26
 * @Version 1.0
 **/
public class CouponsAcquirementVO {
    Long couponId;
    String couponName;
    String couponPictureUrl;
    String couponDescription;
    Double couponDiscount;

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

    public String getCouponPictureUrl() {
        return couponPictureUrl;
    }

    public void setCouponPictureUrl(String couponPictureUrl) {
        this.couponPictureUrl = couponPictureUrl;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
}
