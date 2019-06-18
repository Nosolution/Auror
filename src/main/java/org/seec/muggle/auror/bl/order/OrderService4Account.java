package org.seec.muggle.auror.bl.order;

import org.seec.muggle.auror.vo.order.rechargehistory.RechargeHistoryVO;

/**
 * @Description 提供给Account模块的Order业务
 * @Author 233loser
 * @Date 2019/6/8 21:39
 * @Version 1.0
 **/
public interface OrderService4Account {
    /**
     * @return java.lang.Integer
     * @Author jyh
     * @Description //统计用户的累计消费（不含充值）
     * @Date 11:18 2019/6/8
     * @Param [userId]
     **/
    Integer getConsumptionByUser(Long userId);

    /**
     * @return org.seec.muggle.auror.vo.order.rechargehistory.RechargeHistoryVO[]
     * @Author jyh
     * @Description //获取用户的充值记录
     * @Date 12:19 2019/6/8
     * @Param [userId]
     **/
    RechargeHistoryVO[] getRechargeHistory(Long userId);
}
