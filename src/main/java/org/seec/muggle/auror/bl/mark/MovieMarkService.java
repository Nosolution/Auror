package org.seec.muggle.auror.bl.mark;

import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;

/**
 * @Author jyh
 * @Description //电影想看标记模块
 * @Date 2019/6/4 20:41
 * @Param
 * @return
 **/
public interface MovieMarkService {

    /**
     * @Author jyh
     * @Description //新增一条想看记录
     * @Date 20:46 2019/6/4
     * @Param [userId, movieId]
     * @return void
     **/
    public void mark(Long userId, Long movieId);

    /**
     * @Author jyh
     * @Description //获取某部电影想看曲线，如果某天没有想看的人则返回空数组
     * @Date 20:48 2019/6/4
     * @Param [movieId]
     * @return org.seec.muggle.auror.vo.movie.statistics.FavorNumVO[]
     **/
    public FavorNumVO[] getFavorsByDate(Long movieId);


    /**
     * @Author jyh
     * @Description //获取某人所有想看记录 userStatus; //<1: 已看过>, <2: 未看>； movieStatus; //<1: 未上映>, <2: 已上映>, <3: 已下架>
     * @Date 19:49 2019/6/17
     * @Param [userId]
     * @return org.seec.muggle.auror.vo.user.mark.MovieMarkVO[]
     **/
    public MovieMarkVO[] getFavorsByUserId(Long userId);


}
