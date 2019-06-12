package org.seec.muggle.auror.vo.scene.movie;

import lombok.Data;
import org.seec.muggle.auror.po.Hall;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.IntervalVO;

import java.util.Date;

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
        this.date = DateUtil.dateToString(po.getDate());
        interval = DateUtil.timestampToTimeString(po.getStartTime())+"-"+DateUtil.timestampToTimeString( po.getEndTime());
        this.seats = seats;
    }


}
