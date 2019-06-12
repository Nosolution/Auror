package org.seec.muggle.auror.dao.moviemark;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.FavorRecordPO;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:45
 * @Version 1.0
 **/
@DaoMapper
public interface MovieMarkMapper {

    List<Long> getUserIdsByMovieId(Long movieId);

    Integer insertMark(@Param("userId")Long userId, @Param("movieId")Long movieId, @Param("time") Date time);

    FavorRecordPO getFavorByMovieIdAndUserId(@Param("movieId") Long movieId, @Param("userId") Long userId);

    List<FavorRecordPO> getFavorByMovieId(@Param("movieId") Long movieId);

    List<Long> getMovieIdByUserId(@Param("userId") Long userId);
}
