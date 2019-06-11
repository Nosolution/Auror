package org.seec.muggle.auror.vo.order.unfinished;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:44
 * @Version 1.0
 **/
@Data
public class AvailableCouponsVO {
    Long couponId;
    String couponName;
    Integer discount;
    Date endTime;


    public AvailableCouponsVO(Long couponId, String couponName, Integer discount, Date endTime) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.discount = discount;
        this.endTime = endTime;
    }
}
