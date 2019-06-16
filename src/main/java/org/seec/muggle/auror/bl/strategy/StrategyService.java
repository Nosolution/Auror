package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.vo.strategy.coupongift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
public interface StrategyService {
    RefundStrategyVO getRefundStrategy();

    void updateRefundStrategy(Double rate, Integer beforeTime);

    void createMemberStrategy(String name, String url, Integer threshold, Double rate);

    MemberVarietyVO[] getMemberStrategy();

    void createEvent(EventForm form);

    void deleteEvent(Long eventId);

    EventVO[] getEvents();

    void deleteMemberStrategy(Long strategyId);

    void updateMemberStrategy(MemberVaryForm form);

    void sendCoupon(CouponGiftForm form);

}
