package org.seec.muggle.auror.vo.order.member;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:19
 * @Version 1.0
 **/
@Data
public class MemberPaymentForm {
    Long memberId;
    Long orderId;
    CouponsForm[] coupons;

}
