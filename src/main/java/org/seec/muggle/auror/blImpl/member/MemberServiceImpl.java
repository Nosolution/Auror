package org.seec.muggle.auror.blImpl.member;

import org.seec.muggle.auror.bl.member.MemberService;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.dao.member.MemberMapper;
import org.seec.muggle.auror.po.MemberPO;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.vo.user.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Long;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:55
 * @Version 1.0
 **/
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    StrategyService4Member strategyService4Member;

    @Override
    public MemberVO getPersonalMemberInfo(Long userId) {
        MemberPO member = memberMapper.selectMemberById(userId);
        if(member==null){
            return null;
        }
        else{
            MemberStrategyPO strategyPO = strategyService4Member.getMemberStrategyById(member.getStrategyId());
            return new MemberVO(member,strategyPO);
        }

    }
}
