package org.seec.muggle.auror.vo.scene.Info;

import org.seec.muggle.auror.vo.IntervalVO;

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
    String date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
