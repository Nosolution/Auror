package org.seec.muggle.auror.dao.moviemark;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.FavorRecordPO;

import java.sql.Timestamp;
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

    int insertMark(@Param("userId")Long userId, @Param("movieId")Long movieId, @Param("time") Date time);

    FavorRecordPO findFavorByMovieIdAndUserId(@Param("movieId")Long movieId,@Param("userId")Long userId);

    List<FavorRecordPO> findFavorByMovieId(@Param("movieId")Long movieId);

    List<Long> selectMovieIdByUserId(@Param("userId")Long userId);
}
