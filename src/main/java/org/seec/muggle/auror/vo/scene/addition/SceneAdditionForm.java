package org.seec.muggle.auror.vo.scene.addition;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:55
 * @Version 1.0
 **/
public class SceneAdditionForm {
    Long movieId;
    Long hallId;
    String date;
    String startTime;
    String price;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
