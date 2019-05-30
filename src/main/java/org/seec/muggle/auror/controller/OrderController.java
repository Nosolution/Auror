package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.order.cancellation.CancellationForm;
import org.seec.muggle.auror.vo.order.member.MemberPaymentForm;
import org.seec.muggle.auror.vo.order.member.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.purchase.VipPurchaseForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeVO;
import org.seec.muggle.auror.vo.order.recharge_history.RechargeHistoryVO;
import org.seec.muggle.auror.vo.order.refund.RefundForm;
import org.seec.muggle.auror.vo.order.refund.RefundVO;
import org.seec.muggle.auror.vo.order.third_party.ThirdPartyPaymentForm;
import org.seec.muggle.auror.vo.order.third_party.ThirdPartyPaymentVO;
import org.seec.muggle.auror.vo.order.ticket.TicketDetailVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:17
 * @Version 1.0
 **/
@CrossOrigin
@RestController(value = "/api/order")
public class OrderController {

    @GetMapping(value = "/ticket/unfinished/detail?orderId={orderId}")
    public ResponseEntity<?> checkOrderDetail(@PathVariable Integer orderId){
    boolean isSucc = false;
    if(isSucc){
        return ResponseEntity.ok(new UnfinishedOrderVO());
    }
    else {
        return ResponseEntity.status(405).body("to do");
    }
    }

    @PostMapping(value = "/ticket/payment/member")
    public ResponseEntity<?> memberPayment(@RequestBody MemberPaymentForm form){
        boolean isSucc = false;
        if(isSucc) {
            return ResponseEntity.ok(new MemberPaymentVO());
        }
        else {
            return ResponseEntity.status(405).body("to do");
        }
    }


    @PostMapping(value = "/ticket/payment/third_party")
    public ResponseEntity<?>  third_partyPayment(@RequestBody ThirdPartyPaymentForm form){
        boolean isSucc = false;
        if(isSucc) {
            return ResponseEntity.ok(new ThirdPartyPaymentVO[]{});
        }
        else {
            return ResponseEntity.status(405).body("to do");
        }
    }

    @GetMapping(value = "/ticket")
    public ResponseEntity<?> getAllTickets(){
        boolean isSucc = false;
        if(isSucc) {
            return ResponseEntity.ok(new TicketDetailVO[]{});
        }
        else {
            return ResponseEntity.status(405).body("to do");
        }
    }

    @PutMapping(value = "/ticket/cancellation")
    public ResponseEntity<?>  ticketCancel(@RequestBody CancellationForm form){
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/ticket/refund")
    public ResponseEntity<?> refund(@RequestBody RefundForm form){
        return ResponseEntity.ok(new RefundVO());
    }

    @PostMapping(value = "/member/purchase/payment")
    public ResponseEntity<?> purchaseVIPCard(@RequestBody VipPurchaseForm form){
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/member/recharge/payment")
    public ResponseEntity<?> recharge(@RequestBody RechargeForm form){
        return ResponseEntity.ok(new RechargeVO());
    }

    @GetMapping(value = "/member/recharge/history")
    public ResponseEntity<?> getChargeHistory(){
        return ResponseEntity.ok(new RechargeHistoryVO[]{});
    }
}
