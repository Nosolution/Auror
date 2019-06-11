package org.seec.muggle.auror.vo.order.member;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:26
 * @Version 1.0
 **/
@Data
public class CouponsAcquirementVO {
    Long couponId;
    String couponName;
    String couponPictureUrl;
    String couponDescription;
    Integer couponDiscount;

}
