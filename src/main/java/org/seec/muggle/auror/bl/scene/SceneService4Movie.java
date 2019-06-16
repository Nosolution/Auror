package org.seec.muggle.auror.bl.scene;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description scene模块为movie模块提供的接口
 * @Author 233loser
 * @Date 2019/6/7 18:02
 * @Version 1.0
 **/
public interface SceneService4Movie {

    /**
     * 获取电影排片的所有结束时间
     *
     * @param movieId 电影id
     * @return 结束时间列表
     */
    List<Timestamp> getSceneEndsByMovieId(Long movieId);
}
