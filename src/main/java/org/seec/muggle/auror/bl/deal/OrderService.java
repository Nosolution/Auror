package org.seec.muggle.auror.bl.deal;

import org.seec.muggle.auror.vo.order.member.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.member.PaymentForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeVO;
import org.seec.muggle.auror.vo.order.thirdparty.ThirdPartyPaymentVO;
import org.seec.muggle.auror.vo.order.ticket.TicketDetailVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 12:00
 * @Version 1.0
 **/
public interface OrderService {

    SeatsSelectionVO selectSeats(Long sceneId, Long userId, SelectionForm[] selectedSeats);

    void cancelOrder(Long orderId);

    Double refundOrder(Long orderId);

    void purchaseMember(Long userId, Integer cost, Long memberId);

    UnfinishedOrderVO checkUnfinishedOrder(Long orderId);

    RechargeVO rechargeMember(RechargeForm form, Long userId);


    ThirdPartyPaymentVO finishByThird_party(PaymentForm form);

    MemberPaymentVO finishByMember(PaymentForm form);

    TicketDetailVO[] getAllOrders(Long userId);
}
