package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.order.ticket.MemberPaymentForm;
import org.seec.muggle.auror.vo.order.ticket.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:17
 * @Version 1.0
 **/
@RestController(value = "/order")
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
}
