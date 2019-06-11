package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.account.AccountService;
import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.security.JwtToken;
import org.seec.muggle.auror.util.JwtUtil;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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
//        String authToken = request.getHeader(tokenHeader);
//        final String token = authToken.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        Long userId =
        Long userId = 24L;
        MovieMarkVO[] vos = movieMarkService.getFavorsByUserId(userId);
        return ResponseEntity.ok(vos);
    }

    @GetMapping(value = "/member/info")
    public ResponseEntity<?> getMemberInfo() {
        Long userId = 24L;
        MemberVO vo = memberService.getPersonalMemberInfo(userId);
        if (vo != null) {
            return ResponseEntity.ok(vo);
        } else {
            return ResponseEntity.status(405).body("NOT A MEMBER");
        }
    }

    @GetMapping(value = "/user/message")
    public ResponseEntity<?> getMessage() {
        Long userId = 2L;
        return ResponseEntity.ok(messageService.messages(userId));
    }

    @GetMapping(value = "/user/message/unread_num")
    public ResponseEntity getUnreadNum() {
        Long userId = 1l;
        UnreadNumVO vo = new UnreadNumVO();
        vo.setUnreadNum(messageService.getUnreadNum(userId));
        return ResponseEntity.ok(vo);
    }

    private String getIdFromRequest(HttpServletRequest request){
        String token = request.getHeader(tokenHeader).substring(7);

        return jwtTokenUtil.getUsernameFromToken(token);
    }
}
