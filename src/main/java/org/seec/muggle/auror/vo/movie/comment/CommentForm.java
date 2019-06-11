package org.seec.muggle.auror.vo.movie.comment;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:36
 * @Version 1.0
 **/
@Data
public class CommentForm {
    Long movieId;
    Integer rate; //评分0-10
    String comment;

}
