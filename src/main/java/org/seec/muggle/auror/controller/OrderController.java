package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.deal.OrderService;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.order.cancellation.CancellationForm;
import org.seec.muggle.auror.vo.order.member.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.member.PaymentForm;
import org.seec.muggle.auror.vo.order.purchase.VipPurchaseForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeVO;
import org.seec.muggle.auror.vo.order.refund.RefundForm;
import org.seec.muggle.auror.vo.order.refund.RefundVO;
import org.seec.muggle.auror.vo.order.thirdparty.ThirdPartyPaymentVO;
import org.seec.muggle.auror.vo.order.ticket.TicketDetailVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:17
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    JwtUtil jwtUtil;

    @Value("${jwt.header}")
    String tokenHeader;

    @GetMapping(value = "/ticket/unfinished/detail")
    public ResponseEntity<?> checkOrderDetail(@PathParam("orderId") Long orderId) {
        UnfinishedOrderVO vo = orderService.checkUnfinishedOrder(orderId);
        return ResponseEntity.ok(vo);
    }

    @PostMapping(value = "/ticket/payment/member")
    public ResponseEntity<?> memberPayment(@RequestBody PaymentForm form) {
        MemberPaymentVO vo = orderService.finishByMember(form);
        if (vo != null) {
            return ResponseEntity.ok(vo);
        } else {
            return ResponseEntity.status(405).body("会员卡余额不足");
        }
    }


    @PostMapping(value = "/ticket/payment/third_party")
    public ResponseEntity<?> third_partyPayment(@RequestBody PaymentForm form) {
        ThirdPartyPaymentVO vos = orderService.finishByThird_party(form);
        return ResponseEntity.ok(vos);
    }

    @GetMapping(value = "/ticket")
    public ResponseEntity<?> getAllTickets(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        TicketDetailVO[] ticketDetailVOS = orderService.getAllOrders(userId);
        if (ticketDetailVOS.length != 0) {
            return ResponseEntity.ok(ticketDetailVOS);
        } else {
            return ResponseEntity.status(405).body("没有订单");
        }
    }

    @PutMapping(value = "/ticket/cancellation")
    public ResponseEntity<?> ticketCancel(@RequestBody CancellationForm form) {
        orderService.cancelOrder(form.getOrderId());
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/ticket/refund")
    public ResponseEntity<?> refund(@RequestBody RefundForm form) {
        RefundVO vo = new RefundVO();
        vo.setRefundAmount(orderService.refundOrder(form.getOrderId()));

        return ResponseEntity.ok(vo);
    }

    @PostMapping(value = "/member/purchase/payment")
    public ResponseEntity<?> purchaseVIPCard(HttpServletRequest request,@RequestBody VipPurchaseForm form) {
        Long userId = getIdFromRequest(request);
        orderService.purchaseMember(userId, form.getCost(), form.getMemberStrategyId());
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/member/recharge/payment")
    public ResponseEntity<?> recharge(HttpServletRequest request,@RequestBody RechargeForm form) {
        Long userId = getIdFromRequest(request);
        RechargeVO vo = orderService.rechargeMember(form, userId);
        return ResponseEntity.ok(vo);
    }
    private Long getIdFromRequest(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        return jwtUtil.getIdFromToken(token);
    }

}
