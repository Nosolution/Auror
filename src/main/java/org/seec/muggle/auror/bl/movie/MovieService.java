package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnShelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;

import java.util.List;

/**
 * @Description 业务逻辑层movie模块接口
 * @Author 233loser
 * @Date 2019/6/1 21:33
 * @Version 1.0
 **/
public interface MovieService {
    /**
     * 获取所有当前已上架的电影
     */
    MovieOnShelfVO[] getMovieOnShelf();

    /**
     * 获取7部当前最热门的电影
     */
    MoviePopularVO[] getMoviePopular();

    /**
     * 新增一部影片
     *
     * @param form 影片信息
     */
    void addMovie(MovieAddForm form);

    /**
     * 获取id对应影片的所有评价
     *
     * @param movieId 电影id
     * @return 所有评价
     */
    List<CommentVO> getMovieComment(Long movieId);

    /**
     * 获取影片详细信息
     * TODO 得出得分
     *
     * @param movieId 电影id
     * @return 对应的电影详细信息
     */
    MovieDetailsVO getMovieDetail(Long movieId);

    /**
     * 更新电影信息
     *
     * @param form 新电影信息
     */
    void updateMovie(MovieVaryForm form);

    /**
     * 删除电影
     *
     * @param movieId 电影id
     */
    void deleteMovie(Long movieId);

    /**
     * 评价电影
     *
     * @param movieId 电影id
     * @param userId  用户id
     * @param score   用户评分, 范围[0,10]
     * @param comment 用户评论
     */
    void commentMovie(Long movieId, Long userId, Integer score, String comment);


}
