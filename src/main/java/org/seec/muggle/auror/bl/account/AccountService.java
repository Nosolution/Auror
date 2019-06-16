package org.seec.muggle.auror.bl.account;

import org.seec.muggle.auror.vo.order.rechargehistory.RechargeHistoryVO;
import org.seec.muggle.auror.vo.user.briefinfo.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginVO;

/**
 * @Description 业务逻辑层account模块接口
 * @Author 233loser
 * @Date 2019/6/4 21:42
 * @Version 1.0
 **/
public interface AccountService {

    /**
     * 注册接口, 若成功则不会抛出异常
     *
     * @param username 待注册用户名
     * @param password 将使用的密码
     */
    void register(String username, String password);

    /**
     * 用户登录，若成功则返回token
     *
     * @param username 用户名
     * @param password 密码
     * @return 封装用户编号的token
     */
    LoginVO login(String username, String password);

    /**
     * 用户登出
     *
     * @param token 包含用户编号的token TODO 替换为id
     */
    void logout(String token);

    /**
     * 获取用户所有的优惠券
     *
     * @param userId 用户编号
     * @return 用户所有的优惠券
     */
    UserCouponsVO[] getCoupons(Long userId);

    /**
     * 获取所有已注册用户的基本信息
     */
    BriefInfoVO[] getAllUsers();

    /**
     * 获取用户的充值记录
     *
     * @param userId 用户编号
     */
    RechargeHistoryVO[] getRechargeHistory(Long userId);

}

