package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.entity.movie.Movie4Mark;

/**
 * @Description movie模块为mark模块提供的接口
 * @Author 233loser
 * @Date 2019/6/7 18:33
 * @Version 1.0
 **/
public interface MovieService4Mark {
    /**
     * 根据id获取电影信息
     *
     * @param movieId 电影id
     * @return 电影信息
     */
    Movie4Mark getMovieInfoByIdForMark(Long movieId);
}
