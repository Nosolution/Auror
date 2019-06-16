package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.ScenePO;

/**
 * @Description scene模块为order模块提供的接口
 * @Author 233loser
 * @Date 2019/6/5 14:15
 * @Version 1.0
 **/
public interface SceneService4Order {
    /**
     * 获取排片价格
     *
     * @param sceneId 排片id
     * @return 排片价格
     */
    Integer getPriceByScene(Long sceneId);

    /**
     * 获取排片对应的电影id
     *
     * @param sceneId 排片id
     * @return 电影id
     */
    Long getMovieIdByScene(Long sceneId);

    /**
     * 获取排片信息
     *
     * @param sceneId 排片id
     * @return 对应的排片信息
     */
    ScenePO getSceneById(Long sceneId);
}
