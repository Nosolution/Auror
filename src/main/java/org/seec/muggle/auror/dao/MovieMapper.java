package org.seec.muggle.auror.dao;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.Movie;
import org.seec.muggle.auror.vo.MovieForm;

import java.util.List;

/**
 * @author fjj
 * @date 2019/3/12 6:26 PM
 */
@DaoMapper
public interface MovieMapper {
    /**
     * 插入一条电影信息
     *
     * @param addMovieForm
     * @return
     */
    int insertOneMovie(MovieForm addMovieForm);

    /**
     * 根据id查找电影
     *
     * @param id
     * @return
     */
    Movie selectMovieById(int id);

    /**
     * 根据id和userId查找电影
     *
     * @param id
     * @param userId
     * @return
     */
    Movie selectMovieByIdAndUserId(int id, int userId);

    /**
     * 展示所有电影
     *
     * @return
     */
    List<Movie> selectAllMovie();

    /**
     * 根据关键字搜索电影
     *
     * @param keyword
     * @return
     */
    List<Movie> selectMovieByKeyword(String keyword);
}
