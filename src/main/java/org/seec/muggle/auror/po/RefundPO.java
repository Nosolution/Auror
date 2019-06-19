package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:13
 * @Version 1.0
 **/
@Data
public class RefundPO {
    //在电影上映前多少小时可退款
    Integer beforeTime;
    //描述
    String description;
    //退还率
    Double rate;

}
