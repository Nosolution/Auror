package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description 06-08新增movieId属性，方便判断用户是否看过/统计总票房
 * @Author 233loser
 * @Date 2019/6/5 14:00
 * @Version 1.0
 **/
@Data
public class OrderPO {
    //订单id
    Long id;
    //排片id
    Long sceneId;
    //订单状态
    Integer status;
    //取票码
    String code;
    //订单创立时间
    Timestamp createTime;
    //用户id
    Long userId;
    //订单总金额
    Integer cost;
    //支付方式，<1:第三方支付>, <2:会员支付>
    Integer payMethod;
    //电影id
    Long movieId;

}
