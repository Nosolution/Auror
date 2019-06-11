package org.seec.muggle.auror.vo.strategy.member;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:06
 * @Version 1.0
 **/
@Data
public class MemberVarietyVO {
    Long memberStrategyId;
    String memberStrategyName;
    String memberPictureUrl;
    Integer purchaseThreshold; // 购买(初始充值)起始金额
    Double memberDiscountRate;// 折扣率

}
