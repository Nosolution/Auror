package org.seec.muggle.auror.blImpl.strategy;

import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.strategy.StrategyMapper;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.po.RefundPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
@Service
public class StrategyServiceImpl implements StrategyService, StrategyService4Order {

    @Autowired
    StrategyMapper strategyMapper;

    @Override
    public RefundStrategyVO getRefundStrategy() {
        return new RefundStrategyVO(strategyMapper.selectRefundStrategy().get(0));
    }

    @Override
    public BasicVO updateRefundStrategy(Double rate, Integer beforeTime) {
        RefundPO po = new RefundPO(beforeTime,rate);
        strategyMapper.updateRefundStrategy(po);
        return new BasicVO();
    }
    @Override
    public RefundPO getRefund() {
        return strategyMapper.selectRefundStrategy().get(0);
    }

    @Override
    public BasicVO createMemberStrategy(String name, String url, Integer threshold, Double rate) {
        MemberStrategyPO  po = new MemberStrategyPO(name,url,threshold,rate);
        strategyMapper.insertMemberStrategy(po);
        return new BasicVO();
    }
}
