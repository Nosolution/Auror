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
    Long userId; //用户头像url
    Timestamp commentTime; //评论时间
    String comment;
}
