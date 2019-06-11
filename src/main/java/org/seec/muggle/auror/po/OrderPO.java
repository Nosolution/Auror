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
    Long id;
    Long sceneId;
    Integer status;
    String code;
    Timestamp createTime;
    Long userId;
    Integer cost;
    Integer payMethod;
    Long movieId;

}
