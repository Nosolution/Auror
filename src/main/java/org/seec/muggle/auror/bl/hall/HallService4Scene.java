package org.seec.muggle.auror.bl.hall;

import org.seec.muggle.auror.po.Hall;

/**
 * @Description hall模块为scene模块提供的接口
 * @Author 233loser
 * @Date 2019/6/8 21:11
 * @Version 1.0
 **/
public interface HallService4Scene {
    /**
     * 根据id返回影厅信息
     *
     * @param hallId 影厅编号
     * @return 对应的影厅信息
     */
    Hall getHallById(Long hallId);

    /**
     * 根据影厅名返回影厅id
     *
     * @param hallName 影厅名
     * @return 对应影厅的id
     */
    Long getHallIdByName(String hallName);


}
