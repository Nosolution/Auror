package org.seec.muggle.auror.bl.statistics;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:41
 * @Version 1.0
 **/
public interface MovieMarkService {

    public BasicVO mark(Long userId,Long movieId);

    public FavorNumVO[] getFavorsByDate(Long movieId);

    public MovieMarkVO[] getFavorsByUserId(Long userId);
}
