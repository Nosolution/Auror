package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 21:44
 * @Version 1.0
 **/
public class CouponPO {
    Long id;
    String couponName;
    String description;
    Double discount;
    Integer threshold;
    String url;

    public  CouponPO(){

    }

    public CouponPO(String couponName, String description, Double discount, Integer threshold, String url) {
        this.couponName = couponName;
        this.description = description;
        this.discount = discount;
        this.threshold = threshold;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
