package org.seec.muggle.auror.blImpl.scene;

import org.seec.muggle.auror.bl.movie.MovieService4Scene;
import org.seec.muggle.auror.bl.scene.*;
import org.seec.muggle.auror.dao.scene.SceneMapper;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:24
 * @Version 1.0
 **/
@Service
public class SceneServiceImpl implements SceneService, SceneService4Order, SceneService4Statistics , SceneService4Movie , SceneService4Mark {
    @Autowired
    MovieService4Scene movieService4Scene;

    @Autowired
    SceneMapper sceneMapper;

    @Override
    public BasicVO addScene(Long movieId, Long hallId, Date date, Timestamp startTime, int price) {
        Integer length = movieService4Scene.getLengthById(movieId);
        LocalDateTime end = startTime.toLocalDateTime();
        end = end.plusMinutes(length);
        Timestamp endTime = Timestamp.valueOf(end);
        ScenePO po = new ScenePO(movieId,startTime,endTime,hallId,price,date);
        sceneMapper.insertScene(po);
        return new BasicVO();
    }

    @Override
    public Integer getPriceByScene(Long sceneId) {
        ScenePO po = sceneMapper.selectById(sceneId);
        if(po!=null){
            return po.getPrice();
        }
        else
        {
            return null;
        }
    }

    @Override
    public BasicVO varyScene(Long sceneId, Long movieId, Long hallId, Date date, Timestamp startTime, int price) {
        Integer length = movieService4Scene.getLengthById(movieId);
        LocalDateTime end = startTime.toLocalDateTime();
        end = end.plusMinutes(length);
        Timestamp endTime = Timestamp.valueOf(end);
        ScenePO po = new ScenePO(sceneId,movieId,startTime,endTime,hallId,price,date);
        sceneMapper.updateScene(po);
        return new BasicVO();
    }

    @Override
    public List<ScenePO> getScenesByMovieId(Long movieId) {

        return sceneMapper.selectBymovieId(movieId);

    }

    @Override
    public List<Timestamp> getSceneEndsByMovieId(Long movieId) {
        return sceneMapper.selectEndsBymovieId(movieId);
    }

    @Override
    public List<ScenePO> getScenesById(Long movieId) {
        return sceneMapper.selectBymovieId(movieId);
    }
}
