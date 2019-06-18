package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.entity.strategy.MemberStrategy4Member;

/**
 * @Description 策略模块提供Member模块的接口
 * @Author jyh
 * @Date 2019/6/7 17:13
 * @Version 1.0
 **/
public interface StrategyService4Member {
    /**
     * @return org.seec.muggle.auror.po.MemberStrategyPO
     * @Author jyh
     * @Description //获取会员卡信息
     * @Date 17: 15 2019/6/7
     * @Param [id]
     **/
    MemberStrategy4Member getMemberStrategyById(Long id);
}
