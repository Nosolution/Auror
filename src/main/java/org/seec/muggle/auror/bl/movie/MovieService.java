package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnshelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/1 21:33
 * @Version 1.0
 **/
public interface MovieService {
    public MovieOnshelfVO[] getMovieOnshelf();

    public MoviePopularVO[] getMoviePopular();

    public BasicVO addMovie(MovieAddForm form);

    public List<CommentVO>getMovieComment(Long movieId);

    /**
     * @Author jyh
     * @Description //TODO 得出得分
     * @Date 19:50 2019/6/4
     * @Param [id]
     * @return org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO
     **/
    public MovieDetailsVO getMovieDetail(Long id);

    public BasicVO updateMovie(MovieVaryForm form);
}
