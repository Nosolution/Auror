package org.seec.muggle.auror.vo.scene.movie;

import org.seec.muggle.auror.vo.IntervalVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:03
 * @Version 1.0
 **/
public class MovieSceneInfoVO {
    Long sceneId;
    Long price;
    String hallName;
    String date;
    IntervalVO interval;
    Integer[][] seats;

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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
