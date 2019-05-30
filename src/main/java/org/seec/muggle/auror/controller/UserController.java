package org.seec.muggle.auror.controller;

import javafx.scene.layout.VBox;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginForm;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.seec.muggle.auror.vo.user.member.MemberVO;
import org.seec.muggle.auror.vo.user.message.UnreadNumVO;
import org.seec.muggle.auror.vo.user.register.RegisterForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/28 20:29
 * @Version 1.0
 **/
@CrossOrigin
@RestController(value = "/api")
public class UserController {

    @PostMapping(value = "/login")
    public ResponseEntity<?>  login(@RequestBody LoginForm form){
        LoginVO loginRes = new LoginVO();
        return ResponseEntity.ok(loginRes);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm form){
        boolean isSucc = false;
        if(isSucc) {
            return ResponseEntity.ok("");
        }else {
            return ResponseEntity.status(405).body("");
        }
    }

    @GetMapping(value = "/user/coupon")
    public ResponseEntity<?> getUserCoupons(){
        return ResponseEntity.ok(new UserCouponsVO[]{});
    }

    @GetMapping(value = "/user/brief_info")
    public ResponseEntity<?> getUserBriefInfo(){
        return ResponseEntity.ok(new BriefInfoVO[]{});
    }

    @GetMapping(value = "/user/mark")
    public ResponseEntity<?> getMarkList(){
        return ResponseEntity.ok(new MovieMarkVO[]{});
    }

    @GetMapping(value = "/member/info")
    public ResponseEntity<?> getMemberInfo(){
        boolean isSucc = false;
        if(isSucc){
            return ResponseEntity.ok(new MemberVO());
        }
        else{
            return ResponseEntity.status(405).body("NOT A MEMBER");
        }
    }

    @GetMapping(value = "/message")
    public ResponseEntity<?> getMessage(){
        return  ResponseEntity.ok(new MemberVO[]{});
    }

    @GetMapping(value = "/message/unread_num")
    public ResponseEntity getUnreadNum(){
        return ResponseEntity.ok(new UnreadNumVO());
    }
}
