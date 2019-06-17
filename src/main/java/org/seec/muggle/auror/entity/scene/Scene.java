package org.seec.muggle.auror.entity.scene;

import lombok.Data;
import org.seec.muggle.auror.po.ScenePO;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 为别的模块提供的scene信息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/17
 */
@Data
public class Scene {
    private Long id;
    private Long hallId;
    private Long movieId;
    private Integer price;
    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;

    public Scene() {
    }

    public Scene(ScenePO po) {
        this();
        this.id = po.getId();
        this.hallId = po.getHallId();
        this.movieId = po.getMovieId();
        this.date = po.getDate();
        this.price = po.getPrice();
        this.startTime = po.getStartTime();
        this.endTime = po.getEndTime();
    }
}
