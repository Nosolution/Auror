package org.seec.muggle.auror.vo.scene.movie;

import lombok.Data;
import org.seec.muggle.auror.entity.hall.Hall;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.util.DateConverterUtil;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:03
 * @Version 1.0
 **/
@Data
public class MovieSceneInfoVO {
    Long sceneId;
    Integer price;
    String hallName;
    String date;
    String interval;
    Integer[][] seats;

    public MovieSceneInfoVO(ScenePO po, Hall hall, Integer[][] seats) {
        this.sceneId = po.getId();
        this.price = po.getPrice();
        this.hallName = hall.getName();
        this.date = DateConverterUtil.dateToString(po.getDate());
        interval = DateConverterUtil.timestampToTimeString(po.getStartTime()) + "-" + DateConverterUtil.timestampToTimeString(po.getEndTime());
        this.seats = seats;
    }


}
