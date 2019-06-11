package org.seec.muggle.auror.vo.order.third_party;

import lombok.Data;
import org.seec.muggle.auror.vo.order.member.CouponsAcquirementVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:25
 * @Version 1.0
 **/
@Data
public class ThirdPartyPaymentVO {
    CouponsAcquirementVO[] couponsGot;

}
