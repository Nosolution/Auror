package org.seec.muggle.auror.po;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 18:56
 * @Version 1.0
 **/
@Data
public class UserCouponPO {
    Long id;
    Long couponId;
    Long userId;
    Date start;
    Date end;
}
