package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.ScenePO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 19:42
 * @Version 1.0
 **/
public interface SceneService4Statistics {

    List<ScenePO> getScenesByMovieId(Long movieId);
}
