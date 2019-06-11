package org.seec.muggle.auror.vo.movie.comment;

import lombok.Data;
import org.seec.muggle.auror.po.CommentPO;
import org.seec.muggle.auror.po.UserBasic;
import org.seec.muggle.auror.util.DateUtil;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:39
 * @Version 1.0
 **/
@Data
public class CommentVO {
    String userName;
    String userAvatorUrl; //用户头像url
    String time; //评论时间
    String comment;


    public CommentVO(CommentPO po , UserBasic basic){
        this.comment = po.getComment();
        this.time = DateUtil.timestampToString(po.getCommentTime());
        this.userAvatorUrl = basic.getUrl();
        this.userName = basic.getUsername();
    }
}
