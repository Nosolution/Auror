package org.seec.muggle.auror.po;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 14:17
 * @Version 1.0
 **/
@Data
public class ScenePO {
    Long id;
    Long movieId;
    Timestamp startTime;
    Timestamp endTime;
    Long hallId;
    Integer price;
    Date date;

    public ScenePO() {

    }

    public ScenePO(Long movieId, Timestamp startTime, Timestamp endTime, Long hallId, Integer price, Date date) {
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hallId = hallId;
        this.price = price;
        this.date = date;
    }

    public ScenePO(Long id, Long movieId, Timestamp startTime, Timestamp endTime, Long hallId, Integer price, Date date) {
        this.id = id;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hallId = hallId;
        this.price = price;
        this.date = date;
    }
}
