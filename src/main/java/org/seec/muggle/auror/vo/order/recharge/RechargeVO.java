package org.seec.muggle.auror.vo.order.recharge;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:25
 * @Version 1.0
 **/
@Data
public class RechargeVO {
    Integer credit;//余额
    boolean isUpgraded; // 此次充值是否使会员卡升级
    String newMemberStrategyName;
    String newMemberPictureUrl;
    Double newMemberDiscountRate;
}

