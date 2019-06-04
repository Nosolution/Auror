package org.seec.muggle.auror.bl.hall;

import org.seec.muggle.auror.vo.BasicVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:05
 * @Version 1.0
 **/
public interface HallService {
    BasicVO addHall(String name,int[][] seats);
}
