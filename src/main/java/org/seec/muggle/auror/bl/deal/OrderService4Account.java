package org.seec.muggle.auror.bl.deal;

import org.seec.muggle.auror.vo.order.recharge_history.RechargeHistoryVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 21:39
 * @Version 1.0
 **/
public interface OrderService4Account {
    Integer getConsumptionByUser(Long userId);

    RechargeHistoryVO[] getRechargeHistory(Long userId);
}
