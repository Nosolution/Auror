package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.account.AccountService;
import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginForm;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.seec.muggle.auror.vo.user.member.MemberVO;
import org.seec.muggle.auror.vo.user.message.UnreadNumVO;
import org.seec.muggle.auror.vo.user.register.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/28 20:29
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    MemberService memberService;

    @Autowired
    MovieMarkService movieMarkService;

    @Autowired
    MessageService messageService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form) {

        LoginVO loginRes = accountService.login(form.getUsername(), form.getPassword());
        return ResponseEntity.ok(loginRes);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm form) {
        BasicVO basicVO = accountService.register(form.getUsername(), form.getPassword());
        if (basicVO.isSucc()) {
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.status(405).body(basicVO.getMsg());
        }
    }

    @GetMapping(value = "/user/coupon")
    public ResponseEntity<?> getUserCoupons() {
        Long userId = 1L;
        UserCouponsVO[] couponsVOS = accountService.getCoupons(userId);
        return ResponseEntity.ok(couponsVOS);
    }

    @GetMapping(value = "/user/brief_info")
    public ResponseEntity<?> getUserBriefInfo() {
        BriefInfoVO[] vos = accountService.getUsers();
        return ResponseEntity.ok(vos);
    }

    @GetMapping(value = "/user/mark")
    public ResponseEntity<?> getMarkList() {
        Long userId = 1L;
        MovieMarkVO[] vos = movieMarkService.getFavorsByUserId(userId);
        return ResponseEntity.ok(vos);
    }

    @GetMapping(value = "/member/info")
    public ResponseEntity<?> getMemberInfo() {
        Long userId = 1L;
        MemberVO vo = memberService.getPersonalMemberInfo(userId);
        if (vo != null) {
            return ResponseEntity.ok(vo);
        } else {
            return ResponseEntity.status(405).body("NOT A MEMBER");
        }
    }

    @GetMapping(value = "/message")
    public ResponseEntity<?> getMessage() {
        Long userId = 1L;
        return ResponseEntity.ok(messageService.messages(userId));
    }

    @GetMapping(value = "/message/unread_num")
    public ResponseEntity getUnreadNum() {
        Long userId = 1l;
        UnreadNumVO vo = new UnreadNumVO();
        vo.setUnreadNum(messageService.getUnreadNum(userId));
        return ResponseEntity.ok(vo);
    }
}
