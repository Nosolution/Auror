package org.seec.muggle.auror.blImpl.account;

import org.mindrot.jbcrypt.BCrypt;
import org.seec.muggle.auror.bl.account.AccountService;

import org.seec.muggle.auror.bl.account.AccountService4Movie;
import org.seec.muggle.auror.dao.account.UserMapper;

import org.seec.muggle.auror.enums.RoleEnum;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.User;
import org.seec.muggle.auror.po.UserBasic;
import org.seec.muggle.auror.security.JwtUser;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService , AccountService4Movie {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String LOGIN_ERROR = "用户名或密码错误";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private RoleMapper roleMapper;

//    @Autowired
//    private UserRoleMapper userRoleMapper;

    @Autowired
    private JwtUtil jwtUtil;
/**
 * @Author jyh、hgz
 * @Description //TODO
 * @Date 20:50 2019/6/1
 * @Param [username, password]
 * @return org.seec.muggle.auror.vo.BasicVO
 **/
    @Override
    public BasicVO register(String username, String password) {
        try {
            BasicVO basicVO = new BasicVO();
            if(userMapper.getUserByName(username)!=null){
                basicVO.setSucc(false);
                basicVO.setMsg("用户名已存在");
            }
            else {
                insertNewCUSTOMER(username, password);
                logger.info("账号 {} 注册成功，时间: {}", username, new Timestamp(new Date().getTime()));
                basicVO.setSucc(true);
            }
            return basicVO;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new BaseException(HttpStatus.FORBIDDEN, ACCOUNT_EXIST, e);
        }
    }

    @Override
    public LoginVO login(String username,String password) {
        LoginVO vo = new LoginVO();
        User user = userMapper.getUserByName(username);
        if (null == user || !BCrypt.checkpw(password, user.getPassword())) {
            throw new BaseException(HttpStatus.FORBIDDEN, LOGIN_ERROR);
        }
        vo.setToken(jwtUtil.generateToken(new JwtUser(
                user.getUsername(),
                user.getLastLogoutTime(),
                user.getLastPasswordResetTime())
                )
        );
        return vo;

    }

    @Override
    public void logout(String raw) {
        String token = raw.substring(7);
        String username = jwtUtil.getUsernameFromToken(token);
        User user = userMapper.getUserByName(username);
        user.setLastLogoutTime(new Timestamp(new Date().getTime()));
        userMapper.update(user);
    }

    public User getUser(Integer id) {
        User user = userMapper.get(id);
        return user;
    }

    @Override
    public UserBasic getUserBasicById(Long userId) {
        return null;
    }

    /**
     * 尝试向数据库中插入新的用户记录，保存相关的角色与权限信息
     */
    @Transactional
    void insertNewCUSTOMER(String username, String password) {
        User user = User.generateNerUser(username, password);
        userMapper.insert(user);
        //user被保存后会产生id
        //默认新注册的用户都只拥有顾客权限
//        Role customer = roleMapper.getRoleByName(RoleEnum.CUSTOMER.name().toLowerCase());
//        userRoleMapper.insert(new UserRole(id, customer.getId()));

    }
}