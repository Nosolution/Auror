package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.ScenePO;

import java.util.List;

/**
 * @Description scene模块为statistics模块提供的接口
 * @Author 233loser
 * @Date 2019/6/6 19:42
 * @Version 1.0
 **/
public interface SceneService4Statistics {

    /**
     * 获取电影的所有排片信息
     *
     * @param movieId 电影id
     * @return 排片信息列表
     */
    List<ScenePO> getScenesByMovieId(Long movieId);
}
