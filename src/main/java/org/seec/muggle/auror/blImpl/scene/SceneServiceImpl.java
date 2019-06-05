package org.seec.muggle.auror.blImpl.scene;

import org.seec.muggle.auror.bl.movie.MovieService4Scene;
import org.seec.muggle.auror.bl.scene.SceneService;
import org.seec.muggle.auror.bl.scene.SceneService4Order;
import org.seec.muggle.auror.dao.scene.SceneMapper;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:24
 * @Version 1.0
 **/
@Service
public class SceneServiceImpl implements SceneService, SceneService4Order {
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
        sceneMapper.insertScene(movieId,startTime,endTime,hallId, price,date);
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
}
