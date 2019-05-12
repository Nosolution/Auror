package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户得到的消息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/5/12
 */
@Data
public class Message {
    private Long message;
    private Long userId;
    //消息类型 <0: 被赠送优惠券>, <1: 想看电影上映>, <3: 邀请点评>, <4: 其他>
    private Integer type;
    private String title;
    private String content;
    private Timestamp initTime;
    //是否已读 <0: 未读>, <1: 已读> 那直接 isRead 不就好了吗
    private Integer status;
    //如果是邀请评论则带上电影id
    private Long additionalMovieId;

}
