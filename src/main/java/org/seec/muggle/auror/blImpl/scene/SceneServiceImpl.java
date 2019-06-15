package org.seec.muggle.auror.blImpl.scene;

import org.seec.muggle.auror.bl.deal.OrderService4Scene;
import org.seec.muggle.auror.bl.hall.HallService4Scene;
import org.seec.muggle.auror.bl.message.MessageService4Scene;
import org.seec.muggle.auror.bl.movie.MovieService4Scene;
import org.seec.muggle.auror.bl.scene.*;
import org.seec.muggle.auror.dao.scene.SceneMapper;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:24
 * @Version 1.0
 **/
@Service
public class SceneServiceImpl implements SceneService, SceneService4Order, SceneService4Statistics, SceneService4Movie, SceneService4Mark {
    @Autowired
    HallService4Scene hallService4Scene;

    @Autowired
    MovieService4Scene movieService4Scene;

    @Autowired
    SceneMapper sceneMapper;

    @Autowired
    OrderService4Scene orderService4Scene;

    @Autowired
    MessageService4Scene messageService4Scene;

    @Override
    public void addScene(Long movieId, String hallName, Date date, LocalTime startTime, int price) {
        //第一步判断movie状态是否为0，如果是0 说明第一次上映，给想看的人发消息
        MoviePO moviePO = movieService4Scene.getMovie4Scene(movieId);

        if (moviePO.getStatus() == 1) {
            Message message = new Message();
            message.setContent(moviePO.getMovieName() + "已上映");
            message.setTitle("某部想看电影已上映");
            message.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
            message.setType(1);
            message.setAdditionalMovieId(movieId);
            messageService4Scene.sendMovieOnSceneRemind(message);
        }


        Integer length = movieService4Scene.getLengthById(movieId);
        Timestamp beginTime = DateUtil.datesToTimestamp(date, startTime);
        LocalDateTime start = beginTime.toLocalDateTime();
        LocalDateTime end = start.plusMinutes(length);
        Timestamp endTime = Timestamp.valueOf(end);
        Long hallId = hallService4Scene.getHallIdByName(hallName);
        ScenePO po = new ScenePO(movieId, beginTime, endTime, hallId, price, date);
        sceneMapper.insertScene(po);
        movieService4Scene.setOnScene(movieId);
    }

    @Override
    public Integer getPriceByScene(Long sceneId) {
        ScenePO po = sceneMapper.getById(sceneId);
        if (po != null) {
            return po.getPrice();
        } else {
            return null;
        }
    }

    @Override
    public void varyScene(Long sceneId, Long movieId, String hallName, Date date, LocalTime startTime, int price) {
        Integer length = movieService4Scene.getLengthById(movieId);
        Timestamp beginTime = DateUtil.datesToTimestamp(date, startTime);
        LocalDateTime start = beginTime.toLocalDateTime();
        LocalDateTime end = start.plusMinutes(length);
        Timestamp endTime = Timestamp.valueOf(end);
        Long hallId = hallService4Scene.getHallIdByName(hallName);
        ScenePO po = new ScenePO(sceneId, movieId, beginTime, endTime, hallId, price, date);
        sceneMapper.updateScene(po);
    }

    @Override
    public void deleteScene(Long sceneId) {
        ScenePO scenePO = sceneMapper.getById(sceneId);
        Hall hall = hallService4Scene.getHallById(scenePO.getHallId());
        Integer[][] seats = loadSeats(scenePO, hall);
        for (int i = 0; i < seats.length; i++)
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] > 1)
                    throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "已有用户在该场次订票，无法删除该场次");
            }
    }

    @Override
    public List<ScenePO> getScenesByMovieId(Long movieId) {

        return sceneMapper.getByMovieId(movieId);

    }

    @Override
    public List<Timestamp> getSceneEndsByMovieId(Long movieId) {
        return sceneMapper.getEndsByMovieId(movieId);
    }

    @Override
    public List<ScenePO> getScenesById(Long movieId) {
        return sceneMapper.getByMovieId(movieId);
    }

    @Override
    public Long getMovieIdByScene(Long sceneId) {
        ScenePO po = sceneMapper.getById(sceneId);
        return po.getMovieId();
    }

    @Override
    public ScenePO selectSceneByID(Long sceneId) {
        return sceneMapper.getById(sceneId);
    }

    @Override
    public MovieSceneInfoVO[] getScenesInfoByMovieId(Long movieId) {
        List<MovieSceneInfoVO> vos = new ArrayList<>();
        List<ScenePO> pos = sceneMapper.getByMovieId(movieId);
//        if(pos.size()==0){
//            return new MovieSceneInfoVO[0];
//        }
        pos.stream().sorted((o1, o2) -> {
                    //降序
                    if (o1.getDate().compareTo(o2.getDate()) == 0) {
                        return o2.getStartTime().compareTo(o1.getStartTime());
                    } else {
                        return o2.getDate().compareTo(o1.getDate());
                    }
                }
        ).forEach(o -> {
            Hall hall = hallService4Scene.getHallById(o.getHallId());
            Integer[][] seats = loadSeats(o, hall);
            MovieSceneInfoVO vo = new MovieSceneInfoVO(o, hall, seats);
            vos.add(vo);
        });
        return vos.toArray(new MovieSceneInfoVO[vos.size()]);
    }

    @Override
    public InfoVO[] getScenesInfoByHallIdAndDate(Long hallId, Date date) {
        List<InfoVO> vos = new ArrayList<>();
        List<ScenePO> pos = sceneMapper.getByHallIdAndDate(hallId, date);

        pos.stream()
                .sorted(Comparator.comparing(ScenePO::getStartTime))
                .forEach(o -> {
                    Hall hall = hallService4Scene.getHallById(o.getHallId());
                    Integer[][] seats = loadSeats(o, hall);
                    MoviePO moviePO = movieService4Scene.getMovie4Scene(o.getMovieId());
                    InfoVO vo = new InfoVO(moviePO, seats, o, hall);
                    vos.add(vo);
                });
        return vos.toArray(new InfoVO[vos.size()]);
    }

    private Integer[][] loadSeats(ScenePO scene, Hall hall) {
        Integer[][] seats = hall.getSeats();
        List<TicketPO> ticketPOS = orderService4Scene.getTicketsBySceneId(scene.getId());
        for (TicketPO ticketPO : ticketPOS) {
            seats[ticketPO.getRow()][ticketPO.getColumn()] = 2;
        }
        return seats;
    }
}
