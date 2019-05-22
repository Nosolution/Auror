package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.AccountServiceImpl;
import org.seec.muggle.auror.param.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huwen
 * @date 2019/3/23
 */
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    /**
     * 前端发送登录请求，若登陆成功返回token, 否则返回FORBIDDEN状态码提示用户名或密码错误
     *
     * @param userForm 用户表单信息
     * @return token
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserForm userForm) {
        String token = accountService.login(userForm);
        return ResponseEntity.ok(token);
    }

    /**
     * 注册账户
     *
     * @param userForm 用户表单信息，包括用户名与密码
     * @return 注册结果
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody UserForm userForm) {
        accountService.registerAccount(userForm);
        return ResponseEntity.ok(null);
    }

    /**
     * 登出，使token无效
     *
     * @param request 登出请求
     * @param header  Authorization header
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, @Value("${jwt.header}") String header) {
        String raw = request.getHeader(header);
        accountService.logout(raw);
        return ResponseEntity.ok(null);
    }

    //以下为测试用方法

//    @GetMapping("/anon_user/{id}")
//    public User getAnonUser(@PathVariable Integer id) {
//        return accountService.getUser(id);
//    }
//
//    @GetMapping("/user/{id}")
//    @RequiresAuthentication
//    public User getUser(@PathVariable Integer id) {
//        return accountService.getUser(id);
//    }
//
//    @GetMapping("/hyper_user/{id}")
//    @RequiresRoles({"admin"})
//    public User getHyperUser(@PathVariable Integer id) {
//        return accountService.getUser(id);
//    }
//
//    @GetMapping("/exception")
//    public ResponseEntity<?> getException(){
//        throw new BaseException(HttpStatus.FORBIDDEN, "错误信息");
//    }


}
