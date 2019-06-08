package org.seec.muggle.auror.bl.account;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.UserForm;
import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginVO;
import org.seec.muggle.auror.vo.user.member.MemberVO;

public interface AccountService {

    /**
     * @Author jyh
     * @Description //TODO
     * @Date 21:00 2019/6/1
     * @Param [username, password]
     * @return org.seec.muggle.auror.vo.BasicVO
     **/
    public BasicVO register(String username, String password);

    /**
     * 用户登录，登录成功会返回token
     *
     * @return token
     */
    public LoginVO login(String username, String userpassword);

    /**
     * 退出登录
     *
     * @param token header中带有的token(未截取子串)
     */
    public void logout(String token);

    public UserCouponsVO[] getCoupons(Long userId);

    public BriefInfoVO[] getUsers();

}

