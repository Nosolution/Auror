package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;

import java.time.LocalTime;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:23
 * @Version 1.0
 **/
public interface SceneService {
    void addScene(Long movieId, String hallName, Date date, LocalTime startTime, int price);

    void varyScene(Long sceneId, Long movieId, String hallName, Date date, LocalTime startTime, int price);

    void deleteScene(Long sceneId);

    MovieSceneInfoVO[] getScenesInfoByMovieId(Long movieId);

    InfoVO[] getScenesInfoByHallIdAndDate(Long hallId, Date date);
}
