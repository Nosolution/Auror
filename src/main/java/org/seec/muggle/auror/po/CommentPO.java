package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:39
 * @Version 1.0
 **/
@Data
public class CommentPO {
    //用户id
    Long userId;
    //评论时间
    Timestamp commentTime;
    //评论内容
    String comment;
}
