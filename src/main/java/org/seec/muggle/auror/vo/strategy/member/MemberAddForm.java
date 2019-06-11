package org.seec.muggle.auror.vo.strategy.member;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:14
 * @Version 1.0
 **/
@Data
public class MemberAddForm {
    String memberStrategyName; // 约等于会员卡等级
    String memberPictureUrl;
    Integer purchaseThreshold;
    Double memberDiscountRate;


}
