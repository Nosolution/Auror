package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.po.MoviePO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:26
 * @Version 1.0
 **/
public interface MovieService4Scene {
    Integer getLengthById(Long movieId);

    MoviePO getMovie4Scene(Long movieId);
}
