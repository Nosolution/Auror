package org.seec.muggle.auror.entity.member;

import lombok.Data;
import org.seec.muggle.auror.po.MemberPO;

/**
 * 为其余模块提供会员信息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/17
 */
@Data
public class Member {
    private Long id;
    private Long strategyId;
    private Long userId;
    private Integer credit;

    public Member() {
    }

    public Member(MemberPO po) {
        this();
        this.id = po.getId();
        this.userId = po.getUserId();
        this.strategyId = po.getStrategyId();
        this.credit = po.getCredit();
    }
}
