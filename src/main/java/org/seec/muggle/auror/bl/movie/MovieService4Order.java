package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.po.MoviePO;

/**
 * @Description movie模块为order模块提供的接口
 * @Author 233loser
 * @Date 2019/6/8 18:15
 * @Version 1.0
 **/
public interface MovieService4Order {
    /**
     * 根据id获取电影名
     *
     * @param movieId 电影id
     * @return 电影名
     */
    String getMovieNameById(Long movieId);

    /**
     * 根据id返回电影信息
     *
     * @param movieId 电影id
     * @return 电影信息
     */
    MoviePO getMovieById(Long movieId);
}
