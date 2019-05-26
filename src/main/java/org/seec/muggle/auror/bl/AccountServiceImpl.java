package org.seec.muggle.auror.bl;

import org.mindrot.jbcrypt.BCrypt;
import org.seec.muggle.auror.dao.RoleMapper;
import org.seec.muggle.auror.dao.UserMapper;
import org.seec.muggle.auror.dao.UserRoleMapper;
import org.seec.muggle.auror.enums.RoleEnum;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.Role;
import org.seec.muggle.auror.po.User;
import org.seec.muggle.auror.po.UserRole;
import org.seec.muggle.auror.security.JwtUser;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String LOGIN_ERROR = "用户名或密码错误";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void registerAccount(UserForm userForm) {
        try {
            insertNewUser(userForm.getUsername(), userForm.getPassword());
            logger.info("账号 {} 注册成功，时间: {}", userForm.getUsername(), new Timestamp(new Date().getTime()));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new BaseException(HttpStatus.FORBIDDEN, ACCOUNT_EXIST, e);
        }
    }

    @Override
    public String login(UserForm userForm) {
        User user = userMapper.getUserByName(userForm.getUsername());
        if (null == user || !BCrypt.checkpw(userForm.getPassword(), user.getPassword())) {
            throw new BaseException(HttpStatus.FORBIDDEN, LOGIN_ERROR);
        }
        return jwtUtil.generateToken(new JwtUser(
                user.getUsername(),
                user.getLastLogoutTime(),
                user.getLastPasswordResetTime())
        );
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

    /**
     * 尝试向数据库中插入新的用户记录，保存相关的角色与权限信息
     */
    @Transactional
    void insertNewUser(String username, String password) {
        User user = User.generateNerUser(username, password);
        userMapper.insert(user);
        //user被保存后会产生id
        Integer id = user.getId();
        //默认新注册的用户都只拥有顾客权限
        Role customer = roleMapper.getRoleByName(RoleEnum.CUSTOMER.name().toLowerCase());
        userRoleMapper.insert(new UserRole(id, customer.getId()));

    }
}