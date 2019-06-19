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
    //会员策略id
    Long id;
    //会员卡名称
    String name;
    //会员卡背景图url
    String url;
    //所需购买价格
    Integer price;
    //会员卡折扣率
    Double rate;

    public MemberStrategyPO() {

    }

    public MemberStrategyPO(String name, String url, Integer price, Double rate) {
        this.name = name;
        this.url = url;
        this.price = price;
        this.rate = rate;
    }

    public MemberStrategyPO(MemberStrategy4Member memberStrategy4Member) {
        this.id = memberStrategy4Member.getId();
        this.rate = memberStrategy4Member.getRate();
        this.price = memberStrategy4Member.getThreshold();
        this.url = memberStrategy4Member.getUrl();
        this.name = memberStrategy4Member.getName();

    }
}
