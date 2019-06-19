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
    //排片id
    Long id;
    //电影id
    Long movieId;
    //开始放映时间
    Timestamp startTime;
    //结束放映时间
    Timestamp endTime;
    //影厅id
    Long hallId;
    //票价
    Integer price;
    //日期
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
