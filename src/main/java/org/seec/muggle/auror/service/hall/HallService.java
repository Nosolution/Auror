package org.seec.muggle.auror.service.hall;

import org.seec.muggle.auror.vo.hall.all.SingleHallVO;

/**
 * @Description 业务逻辑层hall模块接口
 * @Author 233loser
 * @Date 2019/6/4 21:05
 * @Version 1.0
 **/
public interface HallService {
    /**
     * 新增影厅
     *
     * @param name  影厅名
     * @param seats 座位图(0为不可用, 1为可用)
     */
    void addHall(String name, int[][] seats);

    /**
     * 获取所有影厅信息
     */
    SingleHallVO[] getAllHalls();

    boolean updateHall(String name,int[][] seats);
}
