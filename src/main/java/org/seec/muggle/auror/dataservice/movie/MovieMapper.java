package org.seec.muggle.auror.dataservice.movie;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dataservice.BaseOperation;
import org.seec.muggle.auror.po.CastPO;
import org.seec.muggle.auror.po.CommentPO;
import org.seec.muggle.auror.po.MoviePO;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/1 21:35
 * @Version 1.0
 **/
@DaoMapper
public interface MovieMapper extends BaseOperation<MoviePO> {
    /**
     * @return java.util.List<org.seec.muggle.auror.po.MoviePO>
     * @Author jyh
     * @Description //筛选出可见之后，下架之前的电影；
     * @Date 18:38 2019/6/4
     * @Param [day]
     **/
    List<MoviePO> getMovieOnShelf();

//    int insertMovie(MoviePO moviePO);

//    MoviePO getMovieById(@Param("id") Long id);

    int insertCast(CastPO po);

    int insertMovieCast(@Param("movieId") Long movieId, @Param("castId") Long castId, @Param("role") String role);

    List<CommentPO> getCommentsByMovieId(@Param("movieId") Long movieId);

//    int updateByMovieId(MoviePO po);

    int updateMovieState(@Param("status") Integer status, @Param("movieId") Long movieId);

    int deleteMovieCastByMovieId(@Param("movieId") Long movieId);

    CastPO getCastByName(@Param("castName") String castName);

    int insertComment(@Param("movieId") Long movieId, @Param("userId") Long userId, @Param("score") Integer score, @Param("comment") String comment, @Param("time") Timestamp timestamp);

//    int deleteMovieByMovieId(@Param("movieId") Long movieId);

    Integer sumScore(Long movieId);

    Integer sumCommentNum(Long movieId);
}
