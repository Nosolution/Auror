package org.seec.muggle.auror.po;

import lombok.Data;
import org.seec.muggle.auror.entity.strategy.MemberStrategy4Member;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 18:29
 * @Version 1.0
 **/
@Data
public class MemberStrategyPO {
    Long id;
    String name;
    String url;
    Integer threshold;
    Double rate;

    public MemberStrategyPO() {

    }

    public MemberStrategyPO(String name, String url, Integer threshold, Double rate) {
        this.name = name;
        this.url = url;
        this.threshold = threshold;
        this.rate = rate;
    }
    public MemberStrategyPO(MemberStrategy4Member memberStrategy4Member){
        this.id = memberStrategy4Member.getId();
        this.rate = memberStrategy4Member.getRate();
        this.threshold = memberStrategy4Member.getThreshold();
        this.url  = memberStrategy4Member.getUrl();
        this.name = memberStrategy4Member.getName();

    }
}
