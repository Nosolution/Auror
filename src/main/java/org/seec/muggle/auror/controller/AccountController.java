package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.AccountServiceImpl;
import org.seec.muggle.auror.config.InterceptorConfiguration;
import org.seec.muggle.auror.dao.User;
import org.seec.muggle.auror.param.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author huwen
 * @date 2019/3/23
 */
@RestController()
public class AccountController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private AccountServiceImpl accountService;


    /**
     * 403: 服务器理解用户发出的请求，但拒绝执行。
     *
     * @param userForm
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserForm userForm, HttpSession session) {
        User user = accountService.login(userForm);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ACCOUNT_INFO_ERROR);
        }
        //注册session
        session.setAttribute(InterceptorConfiguration.SESSION_KEY, userForm);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody UserForm userForm) {
        String res = accountService.registerAccount(userForm);
        if (res.equals("Success")) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
        }
    }

    @PostMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute(InterceptorConfiguration.SESSION_KEY);
        return "index";
    }
}
