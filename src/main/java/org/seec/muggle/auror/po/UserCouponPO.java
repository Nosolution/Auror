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
    //用户优惠券记录id
    Long id;
    //优惠券模板id
    Long couponId;
    //用户id
    Long userId;
    //有效开始日期
    Date start;
    //有效结束日期
    Date end;
}
