package org.seec.muggle.auror.vo.order.unfinished;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:44
 * @Version 1.0
 **/
public class AvailableCouponsVO {
    Long couponId;
    String couponName;
    Double discount;
    String endTime;

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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
