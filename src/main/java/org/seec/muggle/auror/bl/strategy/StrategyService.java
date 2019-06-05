package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
public interface StrategyService {
    RefundStrategyVO getRefundStrategy();

    BasicVO updateRefundStrategy(Double rate,Integer beforeTime);

    BasicVO createMemberStrategy(String name,String url,Integer threshold,Double rate);
}
