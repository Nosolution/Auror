package org.seec.muggle.auror.bl.account;

import org.mindrot.jbcrypt.BCrypt;
import org.seec.muggle.auror.bl.member.MemberService4Account;
import org.seec.muggle.auror.bl.movie.AccountService4Movie;
import org.seec.muggle.auror.bl.order.OrderService4Account;
import org.seec.muggle.auror.bl.strategy.StrategyService4Account;
import org.seec.muggle.auror.dataservice.account.RoleMapper;
import org.seec.muggle.auror.dataservice.account.UserMapper;
import org.seec.muggle.auror.dataservice.account.UserRoleMapper;
import org.seec.muggle.auror.entity.member.MemberAccount;
import org.seec.muggle.auror.entity.strategy.Coupon4Account;
import org.seec.muggle.auror.enums.RoleEnum;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.Role;
import org.seec.muggle.auror.po.User;
import org.seec.muggle.auror.po.UserRole;
import org.seec.muggle.auror.security.JwtUser;
import org.seec.muggle.auror.service.account.AccountService;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.order.rechargehistory.RechargeHistoryVO;
import org.seec.muggle.auror.vo.user.briefinfo.BriefInfoVO;
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
public class AccountServiceImpl implements AccountService, AccountService4Movie, AccountService4Message {
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

    @Override
    public void register(String username, String password) {
        User user = userMapper.getUserByName(username);
        if (user != null)
            throw new BaseException(HttpStatus.OK, "用户名已存在");
        try {
            addNewCustomer(username, password);
            logger.info("账号 {} 注册成功，时间: {}", username, new Timestamp(new Date().getTime()));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new BaseException(HttpStatus.FORBIDDEN, ACCOUNT_EXIST, e);
        }
    }

    @Override
    public LoginVO login(String username, String password) {
        LoginVO vo = new LoginVO();
        User user = userMapper.getUserByName(username);
        if (null == user || !BCrypt.checkpw(password, user.getPassword()))
            throw new BaseException(HttpStatus.UNAUTHORIZED, LOGIN_ERROR);

        vo.setToken(jwtUtil.generateToken(new JwtUser(
                        user.getId(),
                        user.getUsername(),
                        user.getLastLogoutTime(),
                        user.getLastPasswordResetTime())
                )
        );

        vo.setRole(user.getHighestRole().getName());
        return vo;

    }

    @Override
    public void logout(Long id) {
        User user = userMapper.get(id);
        user.setLastLogoutTime(new Timestamp(new Date().getTime()));
        userMapper.update(user);
    }

    @Override
    public String getUsernameById(Long userId) {
        User user = userMapper.getUserById(userId);
        return user.getUsername();
    }

    /**
     * 尝试向数据库中插入新的用户记录，保存相关的角色与权限信息
     */
    @Transactional
    void addNewCustomer(String username, String password) {
        User user = User.generateNerUser(username, password);
        userMapper.insert(user);
//        user被保存后会产生id
//        默认新注册的用户都只拥有顾客权限
        Role customer = roleMapper.getRoleByName(RoleEnum.CUSTOMER.name().toLowerCase());
        userRoleMapper.insert(new UserRole(user.getId(), customer.getId()));
    }

    @Override
    public UserCouponsVO[] getCoupons(Long userId) {
        Coupon4Account[] coupon4Accounts = strategyService4Account.getCouponsByUser(userId);
        UserCouponsVO[] vos = new UserCouponsVO[coupon4Accounts.length];
        for (int i = 0; i < coupon4Accounts.length; i++) {
            vos[i] = new UserCouponsVO(coupon4Accounts[i]);
        }

        return vos;
    }

    @Override
    public BriefInfoVO[] getAllUsers() {
        List<Long> users = userRoleMapper.getAllUserId();
        List<BriefInfoVO> vos = new ArrayList<>();
        users.forEach(o -> {
            BriefInfoVO vo = new BriefInfoVO();
            vo.setUserId(o);
            Optional<Integer> orderConsumption = Optional.ofNullable(orderService4Account.getConsumptionByUser(o));
            MemberAccount memberAccount = memberService4Account.getMemberByUser(o);
            vo.setIsMember(memberAccount.isMember());
            if (memberAccount.isMember()) {
                vo.setMemberCredit(memberAccount.getMemberCredit());
            } else {
                vo.setMemberCredit(-1);
            }
            vo.setUserTotalConsumption(orderConsumption.orElse(0));
            vos.add(vo);
        });
        return vos.toArray(new BriefInfoVO[vos.size()]);
    }

    @Override
    public List<Long> getAllUserId() {
        return userRoleMapper.getAllUserId();
    }

    @Override
    public RechargeHistoryVO[] getRechargeHistory(Long userId) {
        return orderService4Account.getRechargeHistory(userId);
    }
}