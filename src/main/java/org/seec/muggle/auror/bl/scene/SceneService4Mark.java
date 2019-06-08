package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.ScenePO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 18:39
 * @Version 1.0
 **/
public interface SceneService4Mark {
    List<ScenePO> getScenesById(Long movieId);
}
