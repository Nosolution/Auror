package org.seec.muggle.auror.dao.strategy;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.po.RefundPO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:23
 * @Version 1.0
 **/
@DaoMapper
public interface StrategyMapper {
    List<RefundPO> selectRefundStrategy();

    int updateRefundStrategy(RefundPO po);

    int insertMemberStrategy(MemberStrategyPO po);
}
