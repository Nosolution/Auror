package org.seec.muggle.auror.vo.scene.Info;

import org.seec.muggle.auror.po.Hall;
import org.seec.muggle.auror.po.HallPO;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.vo.IntervalVO;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:53
 * @Version 1.0
 **/
public class InfoVO {
    Long sceneId;
    Integer price;
    String hallName;
    Date date;
    IntervalVO interval;
    Integer[][] seats;
    String movieName;
    String posterUrl;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IntervalVO getInterval() {
        return interval;
    }

    public void setInterval(IntervalVO interval) {
        this.interval = interval;
    }

    public Integer[][] getSeats() {
        return seats;
    }

    public void setSeats(Integer[][] seats) {
        this.seats = seats;
    }

    public InfoVO(MoviePO movie, Integer[][] seats, ScenePO scenePO, Hall hall) {
        this.sceneId = scenePO.getId();
        this.price = scenePO.getPrice();
        this.hallName = hall.getName();
        this.date = scenePO.getDate();
        this.interval = new IntervalVO(scenePO.getStartTime(),scenePO.getEndTime());
        this.seats = seats;
        this.movieName = movie.getMovieName();
        this.posterUrl = movie.getPosterUrl();
    }
}
