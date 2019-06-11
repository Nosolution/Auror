package org.seec.muggle.auror.vo.scene.addition;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:55
 * @Version 1.0
 **/
@Data
public class SceneAdditionForm {
    Long movieId;
    Long hallId;
    Date date;
    LocalTime startTime;
    Integer price;

}
