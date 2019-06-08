package org.seec.muggle.auror.bl.scene;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 18:02
 * @Version 1.0
 **/
public interface SceneService4Movie {

    List<Timestamp> getSceneEndsByMovieId(Long movieId);
}
