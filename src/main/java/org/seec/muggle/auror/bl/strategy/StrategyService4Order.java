package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.po.CouponPO;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.po.RefundPO;
import org.seec.muggle.auror.vo.order.member.CouponsForm;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 16:25
 * @Version 1.0
 **/
public interface StrategyService4Order {
    RefundPO getRefund();

    List<AvailableCouponsVO> getCouponsByCost(Integer cost, Long userId);
    
    List<MemberStrategyPO> selectAllMemberStrategy();

    Integer cutDownByCoupons(CouponsForm[] form,Long userId);

    List<CouponPO> sendCoupons(Long movieId,Long userId);


}
