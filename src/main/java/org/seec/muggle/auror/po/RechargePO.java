package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 19:28
 * @Version 1.0
 **/
@Data
public class RechargePO {
    //用户id
    Long userId;
    //充值时间
    Timestamp initTime;
    //充值金额
    Integer cost;
    //1代表购买，2代表充值
    Integer type;

}
