package org.seec.muggle.auror.bl.movie_statistics;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:41
 * @Version 1.0
 **/
public interface MovieMarkService {

    public BasicVO mark(Long userId,Long movieId);

    public FavorNumVO[] getFavorsByDate(Long movieId);
}
