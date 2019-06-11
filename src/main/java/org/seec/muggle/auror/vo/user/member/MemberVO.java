package org.seec.muggle.auror.vo.user.member;

import lombok.Data;
import org.seec.muggle.auror.po.MemberPO;
import org.seec.muggle.auror.po.MemberStrategyPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:51
 * @Version 1.0
 **/
@Data
public class MemberVO {
    Long memberId;
    String memberStrategyName; // 约等于会员卡等级
    String memberPictureUrl;
    Integer memberCredit;
    Double memberDiscount;

    public MemberVO(MemberPO memberPO, MemberStrategyPO strategyPO){
        this.memberCredit = memberPO.getCredit();
        this.memberDiscount = strategyPO.getRate();
        this.memberId = memberPO.getId();
        this.memberPictureUrl = strategyPO.getUrl();
        this.memberStrategyName = strategyPO.getName();
    }
}
