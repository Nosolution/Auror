package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.entity.movie.Movie4Scene;

/**
 * @Description movie模块为scene模块提供的接口
 * @Author 233loser
 * @Date 2019/6/4 21:26
 * @Version 1.0
 **/
public interface MovieService4Scene {
    /**
     * 获取电影长度。单位：分钟
     *
     * @param movieId 电影id
     * @return 电影长度
     */
    Integer getLengthById(Long movieId);

    /**
     * 获取电影信息
     *
     * @param movieId 电影id
     * @return 电影信息
     */
    Movie4Scene getMovieInfoByIdForScene(Long movieId);

}
