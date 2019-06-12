package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.strategy.coupon_gift.CouponGiftForm;
import org.seec.muggle.auror.vo.strategy.event.EventDeletionForm;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberAddForm;
import org.seec.muggle.auror.vo.strategy.member.MemberDeleteForm;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyForm;
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
    public ResponseEntity<?> getRefundStrategy() {
        return ResponseEntity.ok(strategyService.getRefundStrategy());
    }

    @PutMapping(value = "/refund")
    public ResponseEntity<?> varyRefundStrategy(@RequestBody RefundStrategyForm form) {
        strategyService.updateRefundStrategy(form.getRefundRate(), form.getLatestRefundTimeBeforePlaying());
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/event")
    public ResponseEntity<?> getStrategyEvents() {
        EventVO[] vos = strategyService.getEvents();
        return ResponseEntity.ok(vos);
    }

    @PostMapping(value = "/event")
    public ResponseEntity<?> addStrategyEvents(@RequestBody EventForm form) {
        strategyService.createEvent(form);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/event")
    public ResponseEntity<?> deleteEvent(@RequestBody EventDeletionForm form) {
        strategyService.deleteEvent(form.getEventId());
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/coupon_gift")
    public ResponseEntity<?> givingCoupon(@RequestBody CouponGiftForm form) {
        strategyService.sendCoupon(form);
        return ResponseEntity.ok(null);
    }


    @GetMapping(value = "/member")
    public ResponseEntity<?> getVipCardList() {
        MemberVarietyVO[] vos = strategyService.getMemberStrategy();
        return ResponseEntity.ok(vos);
    }

    @PostMapping(value = "/member")
    public ResponseEntity<?> addVipCardVariety(@RequestBody MemberAddForm form) {
        strategyService.createMemberStrategy(form.getMemberStrategyName(), form.getMemberPictureUrl(), form.getPurchaseThreshold(), form.getMemberDiscountRate());
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/member")
    public ResponseEntity<?> deleteVipVariety(@RequestBody MemberDeleteForm form) {
        BasicVO vo = strategyService.deleteMemberStrategy(form.getMemberStrategyId());
        if (vo.isSucc()) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(405).body(vo.getMsg());
        }
    }

    @PutMapping(value = "/member")
    public ResponseEntity<?> varyVipVariety(@RequestBody MemberVaryForm form) {
        BasicVO vo = strategyService.updateMemberStrategy(form);
        if (vo.isSucc()) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(405).body(vo.getMsg());
        }
    }
}
