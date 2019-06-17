package org.seec.muggle.auror.bl.order;

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
 * @Description 业务逻辑层order模块接口
 * @Author jyh
 * @Date 2019/6/5 12:00
 * @Version 1.0
 **/
public interface OrderService {

    /**
     * @Author jyh
     * @Description //生成订单并锁座
     * @Date 12:03 2019/6/5
     * @Param [sceneId, userId, selectedSeats]
     * @return org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO
     **/
    SeatsSelectionVO selectSeats(Long sceneId, Long userId, SelectionForm[] selectedSeats);

    /**
     * @Author jyh
     * @Description //取消订单，将订单状态设置为2
     * @Date 13:13 2019/6/5
     * @Param [orderId]
     * @return void
     **/
    void cancelOrder(Long orderId);

    /**
     * @Author jyh
     * @Description //订单退款，只有符合退款策略的才能退款
     * @Date 13:14 2019/6/6
     * @Param [orderId]
     * @return java.lang.Double
     **/
    Double refundOrder(Long orderId);

    /**
     * @Author jyh
     * @Description //购买会员卡
     * @Date 15:14 2019/6/6
     * @Param [userId, cost, memberId]
     * @return void
     **/
    void purchaseMember(Long userId, Integer cost, Long memberId);

    /**
     * @Author jyh
     * @Description //获取用户未完成的订单
     * @Date 19:14 2019/6/7
     * @Param [orderId]
     * @return org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO
     **/
    UnfinishedOrderVO checkUnfinishedOrder(Long orderId);

    /**
     * @Author jyh
     * @Description //用户充值，充值满一定金额会员卡会自动升级，如果升级
     * isUpgraded = true
     * @Date 19:45 2019/6/7
     * @Param [form, userId]
     * @return org.seec.muggle.auror.vo.order.recharge.RechargeVO
     **/
    RechargeVO rechargeMember(RechargeForm form, Long userId);

    /**
     * @Author jyh
     * @Description //使用第三方支付，默认完成
     * @Date 20:16 2019/6/7
     * @Param [form]
     * @return org.seec.muggle.auror.vo.order.thirdparty.ThirdPartyPaymentVO
     **/
    ThirdPartyPaymentVO finishByThird_party(PaymentForm form);

    /**
     * @Author jyh
     * @Description //TODO
     * @Date 20:16 2019/6/17
     * @Param [form]
     * @return org.seec.muggle.auror.vo.order.member.MemberPaymentVO
     **/
    MemberPaymentVO finishByMember(PaymentForm form);

    /**
     * @Author jyh
     * @Description //获取用户所有订单
     * @Date 21:17 2019/6/7
     * @Param [userId]
     * @return org.seec.muggle.auror.vo.order.ticket.TicketDetailVO[]
     **/
    TicketDetailVO[] getAllOrders(Long userId);
}
