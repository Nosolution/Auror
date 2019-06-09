package org.seec.muggle.auror.dao.scene;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.ScenePO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:23
 * @Version 1.0
 **/
@DaoMapper
public interface SceneMapper {
    int insertScene(ScenePO po);

    int updateScene(ScenePO po);

    ScenePO selectById(@Param("sceneId") Long sceneId);

    List<ScenePO> selectByMovieId(@Param("movieId") Long movieId);

    List<Timestamp> selectEndsByMovieId(@Param("movieId") Long movieId);

    List<ScenePO> selectByHallIdAndDate(@Param("hallId") Long hallId, @Param("date") Date date);

}
