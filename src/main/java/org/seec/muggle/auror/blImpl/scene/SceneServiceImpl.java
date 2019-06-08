package org.seec.muggle.auror.blImpl.scene;

import org.seec.muggle.auror.bl.hall.HallService4Scene;
import org.seec.muggle.auror.bl.movie.MovieService4Scene;
import org.seec.muggle.auror.bl.order.OrderService4Scene;
import org.seec.muggle.auror.bl.scene.*;
import org.seec.muggle.auror.dao.scene.SceneMapper;
import org.seec.muggle.auror.po.Hall;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.po.TicketPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    HallService4Scene hallService4Scene;

    @Autowired
    MovieService4Scene movieService4Scene;

    @Autowired
    SceneMapper sceneMapper;

    @Autowired
    OrderService4Scene orderService4Scene;

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

    @Override
    public Long getMovieIdByScene(Long sceneId) {
        ScenePO po = sceneMapper.selectById(sceneId);
        return po.getMovieId();
    }

    @Override
    public ScenePO selectSceneByID(Long sceneId) {
        return sceneMapper.selectById(sceneId);
    }

    @Override
    public MovieSceneInfoVO[] getScenesInfoByMovieId(Long movieId) {
        List<MovieSceneInfoVO> vos = new ArrayList<>();
        List<ScenePO> pos = sceneMapper.selectBymovieId(movieId);

        pos.stream().forEach(o->{
            Hall hall = hallService4Scene.getHallByhallId(o.getHallId());
            Integer[][] seats = hall.getSeats();
            List<TicketPO> ticketPOS = orderService4Scene.getTicketsBySceneId(o.getId());
            for(int i =0;i<ticketPOS.size();i++){
                seats[ticketPOS.get(i).getRow()][ticketPOS.get(i).getColumn()] = 0;
            }
            MovieSceneInfoVO vo = new MovieSceneInfoVO(o,hall,seats);
            vos.add(vo);
        });
        return vos.toArray(new MovieSceneInfoVO[vos.size()]);
    }

    @Override
    public InfoVO[] getScenesInfoByHallIdAndDate(Long hallId, Date date) {
        List<InfoVO> vos = new ArrayList<>();
        List<ScenePO> pos = sceneMapper.selectByhallIdAndDate(hallId,date);

        pos.stream().forEach(o->{
            Hall hall = hallService4Scene.getHallByhallId(o.getHallId());
            Integer[][] seats = hall.getSeats();
            List<TicketPO> ticketPOS = orderService4Scene.getTicketsBySceneId(o.getId());
            for(int i =0;i<ticketPOS.size();i++){
                seats[ticketPOS.get(i).getRow()][ticketPOS.get(i).getColumn()] = 0;
            }
            MoviePO moviePO = movieService4Scene.getMovie4Scene(o.getMovieId());
            InfoVO vo = new InfoVO(moviePO,seats,o,hall);
            vos.add(vo);
        });
        return vos.toArray(new InfoVO[vos.size()]);
    }
}
