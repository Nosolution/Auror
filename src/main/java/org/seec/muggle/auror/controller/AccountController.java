package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.account.AccountService;
import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.order.recharge_history.RechargeHistoryVO;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginForm;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.seec.muggle.auror.vo.user.member.MemberVO;
import org.seec.muggle.auror.vo.user.message.UnreadNumVO;
import org.seec.muggle.auror.vo.user.register.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    private JwtUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

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
            return ResponseEntity.ok(basicVO);
        } else {
            return ResponseEntity.status(200).body(basicVO);
        }
    }

    @GetMapping(value = "/user/coupon")
    public ResponseEntity<?> getUserCoupons(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        UserCouponsVO[] couponsVOS = accountService.getCoupons(userId);
        return ResponseEntity.ok(couponsVOS);
    }

    @GetMapping(value = "/user/brief_info")
    public ResponseEntity<?> getUserBriefInfo() {
        BriefInfoVO[] vos = accountService.getUsers();
        return ResponseEntity.ok(vos);
    }

    @GetMapping(value = "/user/mark")
    public ResponseEntity<?> getMarkList(HttpServletRequest request) {
//        String authToken = request.getHeader(tokenHeader);
//        final String token = authToken.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        Long userId =
        Long userId = getIdFromRequest(request);
        MovieMarkVO[] vos = movieMarkService.getFavorsByUserId(userId);
        return ResponseEntity.ok(vos);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(HttpServletRequest request) {
        return ResponseEntity.ok(getIdFromRequest(request));
    }

    @GetMapping(value = "/member/info")
    public ResponseEntity<?> getMemberInfo(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        MemberVO vo = memberService.getPersonalMemberInfo(userId);
        vo.setMember(vo==null);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/user/message")
    public ResponseEntity<?> getMessage(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        return ResponseEntity.ok(messageService.messages(userId));
    }

    @GetMapping(value = "/user/message/unread_num")
    public ResponseEntity<?> getUnreadNum(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        UnreadNumVO vo = new UnreadNumVO();
        vo.setUnreadNum(messageService.getUnreadNum(userId));
        return ResponseEntity.ok(vo);
    }

    private Long getIdFromRequest(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        return jwtTokenUtil.getIdFromToken(token);
    }

    @GetMapping(value = "/order/member/recharge/history")
    public ResponseEntity<?> getChargeHistory(HttpServletRequest request) {
        Long userId = getIdFromRequest(request);
        RechargeHistoryVO[] vos = accountService.getRechargeHistory(userId);
        return ResponseEntity.ok(vos);
    }


}
