package org.seec.muggle.auror.blimpl.member;

import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.member.MemberService4Account;
import org.seec.muggle.auror.bl.member.MemberService4Order;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.dao.member.MemberMapper;
import org.seec.muggle.auror.entity.member.Member;
import org.seec.muggle.auror.entity.member.MemberAccount;
import org.seec.muggle.auror.po.MemberPO;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.vo.user.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:55
 * @Version 1.0
 **/
@Service
public class MemberServiceImpl implements MemberService, MemberService4Order, MemberService4Account {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    StrategyService4Member strategyService4Member;

    @Override
    public MemberVO getPersonalMemberInfo(Long userId) {
        MemberPO member = memberMapper.getMemberByUserId(userId);
        if (member == null) {
            return null;
        } else {
            MemberStrategyPO strategyPO = new MemberStrategyPO(strategyService4Member.getMemberStrategyById(member.getStrategyId()));
            return new MemberVO(member, strategyPO);
        }

    }

    @Override
    public Member getMemberByUserId(Long userId) {
        MemberPO po = memberMapper.getMemberByUserId(userId);
        return new Member(po);
    }

    @Override
    public void changeStrategy(Long userId, Long strategyId) {
        memberMapper.updateMemberByUserId(userId, strategyId);
    }

    @Override
    public void recharge(Long userId, Integer cost) {
        MemberPO po = memberMapper.getMemberByUserId(userId);
        memberMapper.updateCredit(cost + po.getCredit(), userId);
    }

    @Override
    public MemberAccount getMemberByUser(Long userId) {
        MemberPO po = memberMapper.getMemberByUserId(userId);
        MemberAccount account = new MemberAccount();
        account.setMember(po != null);
        if (po != null) {
            account.setMemberCredit(po.getCredit());
        }
        return account;

    }

    @Override
    public Integer payByMember(Long userId, Integer cost) {
        MemberPO member = memberMapper.getMemberByUserId(userId);
        MemberStrategyPO strategyPO = new MemberStrategyPO(strategyService4Member.getMemberStrategyById(member.getStrategyId()));
        if (member.getCredit() < cost) {
            return -1;
        } else {
            memberMapper.updateCredit(member.getCredit() - (int) (cost * strategyPO.getRate()), userId);
        }
        return (int) (cost * strategyPO.getRate());
    }
}
