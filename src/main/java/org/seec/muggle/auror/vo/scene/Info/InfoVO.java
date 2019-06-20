package org.seec.muggle.auror.vo.scene.Info;

import lombok.Data;
import org.seec.muggle.auror.entity.hall.Hall;
import org.seec.muggle.auror.entity.movie.Movie4Scene;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.util.DateConverterUtil;
import org.seec.muggle.auror.vo.IntervalVO;

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


    public InfoVO(Movie4Scene movie, Integer[][] seats, ScenePO scenePO, Hall hall) {
        this.sceneId = scenePO.getId();
        this.price = scenePO.getPrice();
        this.hallName = hall.getName();
        this.date = DateConverterUtil.dateToString(scenePO.getDate());
        this.interval = new IntervalVO(scenePO.getStartTime(), scenePO.getEndTime());
        this.seats = seats;
        this.movieName = movie.getMovieName();
        this.posterUrl = movie.getPosterUrl();
        this.length = movie.getLength();
    }
}
