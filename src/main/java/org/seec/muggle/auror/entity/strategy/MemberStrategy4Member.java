package org.seec.muggle.auror.entity.strategy;

import lombok.Data;
import org.seec.muggle.auror.po.MemberStrategyPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/17 20:59
 * @Version 1.0
 **/
@Data
public class MemberStrategy4Member {
    Long id;
    String name;
    String url;
    Integer threshold;
    Double rate;

    public MemberStrategy4Member(MemberStrategyPO po) {
        this.id = po.getId();
        this.name = po.getName();
        this.url = po.getUrl();
        this.threshold = po.getPrice();
        this.rate = po.getRate();
    }
}
