package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:23
 * @Version 1.0
 **/
public interface SceneService {
    BasicVO addScene(Long movieId, Long hallId, Date date, Timestamp startTime,int price);

    BasicVO varyScene(Long sceneId,Long movieId,Long hallId,Date date,Timestamp startTime,int price);

    MovieSceneInfoVO[] getScenesInfoByMovieId(Long movieId);

    InfoVO[] getScenesInfoByHallIdAndDate(Long hallId,Date date);
}
