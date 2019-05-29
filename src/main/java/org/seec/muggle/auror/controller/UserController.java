package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.user.LoginForm;
import org.seec.muggle.auror.vo.user.LoginVO;
import org.seec.muggle.auror.vo.user.RegisterForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/28 20:29
 * @Version 1.0
 **/
@RestController
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


}
