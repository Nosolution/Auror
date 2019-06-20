package org.seec.muggle.auror.vo.hall.update;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/20 22:16
 * @Version 1.0
 **/
@Data
public class HallUpdateForm {
    String hallName;
    int[][]  seats;
}
