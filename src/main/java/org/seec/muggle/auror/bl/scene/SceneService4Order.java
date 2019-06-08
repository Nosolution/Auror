package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.ScenePO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 14:15
 * @Version 1.0
 **/
public interface SceneService4Order {
    Integer getPriceByScene(Long sceneId);

    Long getMovieIdByScene(Long sceneId);

    ScenePO selectSceneByID(Long sceneId);
}
