package org.seec.muggle.auror.bl;


import org.seec.muggle.auror.po.Movie;
import org.seec.muggle.auror.vo.DateLikeForm;
import org.seec.muggle.auror.vo.MovieForm;

import java.util.List;

/**
 *
 */
public interface MovieService {
    /**
     * 上架电影
     *
     * @param addMovieForm
     * @return
     */
    boolean addMovie(MovieForm addMovieForm);

    /**
     * 根据id搜索电影
     *
     * @param id
     * @param userId
     * @return
     */
    Movie searchOneMovieByIdAndUserId(int id, int userId);

    /**
     * 搜索全部电影
     *
     * @return
     */
    List<Movie> searchAllMovie();

    /**
     * 想看电影
     *
     * @param userId
     * @param movieId
     * @return
     */
    String likeMovie(int userId, int movieId);

    /**
     * 取消想看电影
     *
     * @param userId
     * @param movieId
     * @return
     */
    String unLikeMovie(int userId, int movieId);

    /**
     * 统计想看电影的人数
     *
     * @param movieId
     * @return
     */
    int getCountOfLikes(int movieId);


    /**
     * 根据关键字搜索电影
     *
     * @param keyword
     * @return
     */
    List<Movie> getMovieByKeyword(String keyword);

    /**
     * 获得电影每日的想看人数
     *
     * @param movieId
     * @return
     */
    List<DateLikeForm> getLikeNumsGroupByDate(int movieId);

}
