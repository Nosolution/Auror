package org.seec.muggle.auror.vo;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/12 14:25
 * @Version 1.0
 **/
public class MessageForm {
    Integer messageType; //<0: 被赠送优惠券>, <1: 想看电影上映>, <3: 邀请点评>, <4: 新优惠活动>,<5: 其他>
    String messageTitle; //消息标题
    String messageContent; //消息内容
    String initTime;// 发送时间
    Integer messageStatus;// <0: 未读>, <1: 已读> 第一次GET得到的状态是未读，之后GET得到的状态都是已读
    Long additionalMovieId;


}
