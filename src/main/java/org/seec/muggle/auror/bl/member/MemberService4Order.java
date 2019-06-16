package org.seec.muggle.auror.bl.member;

import org.seec.muggle.auror.po.MemberPO;

/**
 * @Description member模块为order模块提供的接口
 * @Author 233loser
 * @Date 2019/6/8 19:48
 * @Version 1.0
 **/
public interface MemberService4Order {
    /**
     * 获取用户会员信息
     *
     * @param userId 用户id
     * @return 会员信息
     */
    MemberPO getMemberByUserId(Long userId);

    /**
     * 修改用户会员对应的策略
     *
     * @param userId     用户id
     * @param strategyId 策略id
     */
    void changeStrategy(Long userId, Long strategyId);

    /**
     * 会员账户充值
     *
     * @param cost   充值数目
     * @param userId 用户id
     */
    void recharge(Long userId, Integer cost);

    /**
     * 使用会员账户支付订单
     *
     * @param cost   花费
     * @param userId 用户id
     * @return 实际扣除的额度
     */
    Integer payByMember(Long userId, Integer cost);
}
