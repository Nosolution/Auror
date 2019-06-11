package org.seec.muggle.auror.blImpl.member;

import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.member.MemberService4Account;
import org.seec.muggle.auror.bl.member.MemberService4Order;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.dao.member.MemberMapper;
import org.seec.muggle.auror.po.Member4Account;
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
        MemberPO member = memberMapper.selectMemberById(userId);
        if (member == null) {
            return null;
        } else {
            MemberStrategyPO strategyPO = strategyService4Member.getMemberStrategyById(member.getStrategyId());
            return new MemberVO(member, strategyPO);
        }

    }

    @Override
    public MemberPO getMemberByUserId(Long userId) {
        MemberPO po = memberMapper.selectMemberById(userId);
        return po;
    }

    @Override
    public void changeStrategy(Long userId, Long strategyId) {
        memberMapper.updateMemberById(userId, strategyId);
    }

    @Override
    public void recharge(Integer cost, Long userId) {
        MemberPO po = memberMapper.selectMemberById(userId);
        memberMapper.updateCredit(cost + po.getCredit(), userId);
    }

    @Override
    public Member4Account getMemberByUser(Long userid) {
        MemberPO po = memberMapper.selectMemberById(userid);
        if (po == null) {
            Member4Account account = new Member4Account();
            account.setMember(false);
            return account;
        } else {
            Member4Account account = new Member4Account();
            account.setMember(true);
            account.setMemberCredit(po.getCredit());
            return account;
        }

    }

    @Override
    public boolean payByMember(Integer cost, Long userId) {
        MemberPO member = memberMapper.selectMemberById(userId);
        if (member.getCredit() < cost) {
            return false;
        } else {
            memberMapper.updateCredit(member.getCredit() - cost, userId);
        }
        return true;
    }
}
