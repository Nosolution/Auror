package org.seec.muggle.auror.dao.movie;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.MoviePO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/1 21:35
 * @Version 1.0
 **/
@DaoMapper
public interface MovieMapper {
    /**
     * @Author jyh
     * @Description //筛选出可见之后，下架之前的电影；
     * @Date 18:38 2019/6/4
     * @Param [day]
     * @return java.util.List<org.seec.muggle.auror.po.MoviePO>
     **/
    List<MoviePO> getMovieOnshelf(Date day);

    int insertMovie(MoviePO moviePO);

    MoviePO findMovieById(@Param("id") Long id);

    MoviePO findByMovieName(@Param("movieName")String movieName);

    int insertCast(@Param("url")String url,@Param("name")String name);

    int insertMovieCast(@Param("movieName")String movieName,@Param("castName")String castName,@Param("castRole") String role);
}
