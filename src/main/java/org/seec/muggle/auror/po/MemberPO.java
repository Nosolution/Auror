package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:58
 * @Version 1.0
 **/
@Data
public class MemberPO {
    //会员id
    Long id;
    //会员策略id
    Long strategyId;
    //用户id
    Long userId;
    //会员卡余额
    Integer credit;

}
