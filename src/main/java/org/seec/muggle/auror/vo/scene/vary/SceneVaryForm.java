package org.seec.muggle.auror.vo.scene.vary;

import lombok.Data;

import java.time.LocalTime;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:58
 * @Version 1.0
 **/
@Data
public class SceneVaryForm {
    Long sceneId;
    String hallName;
    String date;
    LocalTime startTime;
    Integer price;


}
