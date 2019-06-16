package org.seec.muggle.auror.vo.scene.Info;

import lombok.Data;
import org.seec.muggle.auror.po.Hall;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.IntervalVO;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:53
 * @Version 1.0
 **/
@Data
public class InfoVO {
    Long sceneId;
    Integer price;
    String hallName;
    String date;
    IntervalVO interval;
    Integer[][] seats;
    String movieName;
    String posterUrl;
    Integer length;



    public InfoVO(MoviePO movie, Integer[][] seats, ScenePO scenePO, Hall hall) {
        this.sceneId = scenePO.getId();
        this.price = scenePO.getPrice();
        this.hallName = hall.getName();
        this.date = DateUtil.dateToString(scenePO.getDate());
        this.interval = new IntervalVO(scenePO.getStartTime(), scenePO.getEndTime());
        this.seats = seats;
        this.movieName = movie.getMovieName();
        this.posterUrl = movie.getPosterUrl();
        this.length = movie.getLength();
    }
}
