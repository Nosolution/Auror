package org.seec.muggle.auror.dao.scene;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:23
 * @Version 1.0
 **/
@DaoMapper
public interface SceneMapper {
    int insertScene(@Param("movieId")Long movieId,@Param("startTime") Timestamp startTime,@Param("endTime")Timestamp end,@Param("hallId") Long hallId,@Param("price") Integer price,@Param("date") Date date);
}
