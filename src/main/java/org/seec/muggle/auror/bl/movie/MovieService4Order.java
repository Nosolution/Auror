package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.po.MoviePO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 18:15
 * @Version 1.0
 **/
public interface MovieService4Order {
    String getMovieNameById(Long movieId);

    MoviePO getMovieById(Long movieId);
}
