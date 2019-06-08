package org.seec.muggle.auror.bl.strategy;

import org.apache.shiro.event.Event;
import org.seec.muggle.auror.vo.BasicVO;
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

    BasicVO updateRefundStrategy(Double rate,Integer beforeTime);

    BasicVO createMemberStrategy(String name,String url,Integer threshold,Double rate);

    MemberVarietyVO[] getMemberStrategy();

    BasicVO createEvent(EventForm form);

    BasicVO deleteEvent(Long eventId);

    EventVO[] getEvents();

    BasicVO deleteMemberStrategy(Long strategyId);

    BasicVO updateMemberStrategy(MemberVaryForm form);

}
