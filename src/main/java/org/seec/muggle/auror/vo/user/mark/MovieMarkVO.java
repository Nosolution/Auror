package org.seec.muggle.auror.vo.user.mark;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:46
 * @Version 1.0
 **/
@Data
public class MovieMarkVO {
    String posterUrl;
    Long movieId; // 电影Id
    String movieName;// 电影名称
    String movieType;// 电影类别（动作片）
    Integer movieYear;// 电影年份
    Integer movieLength;// 电影时长
    String movieDescription;// 电影简介
    Integer userStatus; //<1: 已看过>, <2: 未看>
    Integer movieStatus; //<1: 未上映>, <2: 已上映>, <3: 已下架>
}
