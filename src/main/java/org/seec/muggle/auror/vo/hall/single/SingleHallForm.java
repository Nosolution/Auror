package org.seec.muggle.auror.vo.hall.single;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:07
 * @Version 1.0
 **/
@Data
public class SingleHallForm {
    String hallName;
    int[][] seats;//0代表不可用，1代表可用

}
