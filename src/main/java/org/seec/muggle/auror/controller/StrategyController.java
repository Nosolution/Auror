package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.vo.strategy.coupon_gift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventDeletionForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyForm;
import org.seec.muggle.auror.vo.strategy.member.MemberAddForm;
import org.seec.muggle.auror.vo.strategy.member.MemberDeleteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:51
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api/strategy")
public class StrategyController {
    @Autowired
    StrategyService strategyService;

    @GetMapping(value = "/refund")
    public ResponseEntity<?> getRefundStrategy(){
        return ResponseEntity.ok(strategyService.getRefundStrategy());
    }

    @PutMapping(value = "/refund")
    public ResponseEntity<?> varyRefundStrategy(@RequestBody RefundStrategyForm form){
        strategyService.updateRefundStrategy(form.getRefundRate(),form.getLatestRefundTimeBeforePaying());
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/event")
    public ResponseEntity getStrategyEvents(){
        return ResponseEntity.ok(new EventVO[]{});
    }
    @PostMapping(value = "/event")
    public ResponseEntity addStrategyEvents(@RequestBody EventForm form){
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "/event")
    public ResponseEntity<?> deleteEvent(@RequestBody EventDeletionForm form){
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/coupon_gift")
    public ResponseEntity<?> givingCoupon(@RequestBody CouponGiftForm form){
        return ResponseEntity.ok("");
    }


    @GetMapping(value = "/member")
    public ResponseEntity<?> getVipCardList(){
        return ResponseEntity.ok(new MemberVarietyVO[]{});
    }

    @PostMapping(value = "/member")
    public ResponseEntity<?> addVipCardVariety(@RequestBody MemberAddForm form){
        strategyService.createMemberStrategy(form.getMemberStrategyName(),form.getMemberPictureurl(),form.getPurchaseThreshold(),form.getMemberDiscountRate());
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "/member")
    public ResponseEntity<?> deleteVipVariety(@RequestBody MemberDeleteForm form){
        return ResponseEntity.ok("");
    }

    @PutMapping(value = "/member")
    public ResponseEntity<?> varyVipVariety(@RequestBody MemberVaryForm form){
        return ResponseEntity.ok("");
    }
}
