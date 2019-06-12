package org.seec.muggle.auror.blImpl.account;

import org.mindrot.jbcrypt.BCrypt;
import org.seec.muggle.auror.bl.account.AccountService;
import org.seec.muggle.auror.bl.account.AccountService4Message;
import org.seec.muggle.auror.bl.account.AccountService4Movie;
import org.seec.muggle.auror.bl.deal.OrderService4Account;
import org.seec.muggle.auror.bl.member.MemberService4Account;
import org.seec.muggle.auror.bl.strategy.StrategyService4Account;
import org.seec.muggle.auror.dao.account.RoleMapper;
import org.seec.muggle.auror.dao.account.UserMapper;
import org.seec.muggle.auror.dao.account.UserRoleMapper;
import org.seec.muggle.auror.enums.RoleEnum;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.security.JwtUser;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.order.recharge_history.RechargeHistoryVO;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, AccountService4Movie , AccountService4Message {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String LOGIN_ERROR = "用户名或密码错误";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService4Account memberService4Account;

    @Autowired
    StrategyService4Account strategyService4Account;

    @Autowired
    OrderService4Account orderService4Account;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * @return org.seec.muggle.auror.vo.BasicVO
     * @Author jyh、hgz
     * @Description //TODO
     * @Date 20:50 2019/6/1
     * @Param [username, password]
     **/
    @Override
    public BasicVO register(String username, String password) {
        try {
            BasicVO basicVO = new BasicVO();
            User user = userMapper.getUserByName(username);
            if (user != null) {
                basicVO.setSucc(false);
                basicVO.setMsg("用户名已存在");
                return basicVO;
            } else {
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
    public LoginVO login(String username, String password) {
        LoginVO vo = new LoginVO();
        User user = userMapper.getUserByName(username);
//        if (null == user || !BCrypt.checkpw(password, user.getPassword())) {
//            throw new BaseException(HttpStatus.FORBIDDEN, LOGIN_ERROR);
//        }
        if (null == user || !BCrypt.checkpw(password, user.getPassword()))
            throw new BaseException(HttpStatus.UNAUTHORIZED, LOGIN_ERROR);

        vo.setToken(jwtUtil.generateToken(new JwtUser(
                        user.getId(),
                        user.getUsername(),
                        user.getLastLogoutTime(),
                        user.getLastPasswordResetTime())
                )
        );
        vo.setRole(roleMapper.getRolesByUserId(user.getId()).get(0).getName());
        return vo;

    }

    @Override
    public void logout(String raw) {
        String token = raw.substring(7);
        Long id = jwtUtil.getIdFromToken(token);
        User user = userMapper.get(id);
        user.setLastLogoutTime(new Timestamp(new Date().getTime()));
        userMapper.update(user);
    }

    public User getUser(Long id) {
        User user = userMapper.get(id);
        return user;
    }

    @Override
    public UserBasic getUserBasicById(Long userId) {
        UserBasic basic = new UserBasic();
        User user = userMapper.getUserById(userId);
        basic.setUrl("");
        basic.setUsername(user.getUsername());
        return basic;
    }

    /**
     * 尝试向数据库中插入新的用户记录，保存相关的角色与权限信息
     */
    @Transactional
    void insertNewCUSTOMER(String username, String password) {
        User user = User.generateNerUser(username, password);
        userMapper.insert(user);
//        user被保存后会产生id
//        默认新注册的用户都只拥有顾客权限
        Role customer = roleMapper.getRoleByName(RoleEnum.CUSTOMER.name().toLowerCase());
        userRoleMapper.insert(new UserRole(user.getId(), customer.getId()));
    }

    @Override
    public UserCouponsVO[] getCoupons(Long userId) {
        return strategyService4Account.getCouponsByUser(userId);
    }

    @Override
    public BriefInfoVO[] getUsers() {
        List<Long> users = userRoleMapper.getAllUser();
        List<BriefInfoVO> vos = new ArrayList<>();
        users.forEach(o -> {
            BriefInfoVO vo = new BriefInfoVO();
            vo.setUserId(o);
            Optional<Integer> orderConsumption = Optional.ofNullable(orderService4Account.getConsumptionByUser(o));
            Member4Account member4Account = memberService4Account.getMemberByUser(o);
            vo.setIsMember(member4Account.isMember());
            if (member4Account.isMember()) {
                vo.setMemberCredit(member4Account.getMemberCredit());
            } else {
                vo.setMemberCredit(-1);
            }
            vo.setUserTotalConsumption(orderConsumption.orElse(0));
            vos.add(vo);
        });
        return vos.toArray(new BriefInfoVO[vos.size()]);
    }

    @Override
    public RechargeHistoryVO[] getRechargeHistory(Long userId) {
        return  orderService4Account.getRechargeHistory(userId);
    }
}