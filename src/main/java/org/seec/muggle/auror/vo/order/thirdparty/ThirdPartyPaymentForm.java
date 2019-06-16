package org.seec.muggle.auror.vo.order.thirdparty;

import lombok.Data;
import org.seec.muggle.auror.vo.order.member.CouponsForm;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:21
 * @Version 1.0
 **/
@Data
public class ThirdPartyPaymentForm {
    Long orderId;
    CouponsForm[] coupons;

}
