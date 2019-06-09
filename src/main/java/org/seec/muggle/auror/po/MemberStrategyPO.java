package org.seec.muggle.auror.po;

import lombok.Data;

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
}
