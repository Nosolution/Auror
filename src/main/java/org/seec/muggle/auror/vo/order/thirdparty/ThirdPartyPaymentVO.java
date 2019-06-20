package org.seec.muggle.auror.vo.order.thirdparty;

import lombok.Data;
import org.seec.muggle.auror.vo.order.member.AcquiredCouponsVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:25
 * @Version 1.0
 **/
@Data
public class ThirdPartyPaymentVO {
    AcquiredCouponsVO[] couponsGot;

}
