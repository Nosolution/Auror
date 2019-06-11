package org.seec.muggle.auror.vo.movie.comment;

import org.seec.muggle.auror.po.CommentPO;
import org.seec.muggle.auror.po.UserBasic;
import org.seec.muggle.auror.util.DateUtil;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:39
 * @Version 1.0
 **/
public class CommentVO {
    String userName;
    String userAvatorUrl; //用户头像url
    String time; //评论时间
    String comment;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatorUrl() {
        return userAvatorUrl;
    }

    public void setUserAvatorUrl(String userAvatorUrl) {
        this.userAvatorUrl = userAvatorUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time =  DateUtil.timestampToString(time);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentVO(CommentPO po , UserBasic basic){
        this.comment = po.getComment();
        this.time = DateUtil.timestampToString(po.getCommentTime());
        this.userAvatorUrl = basic.getUrl();
        this.userName = basic.getUsername();
    }
}
