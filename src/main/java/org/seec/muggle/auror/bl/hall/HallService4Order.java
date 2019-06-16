package org.seec.muggle.auror.bl.hall;

/**
 * @Description hall模块为order模块提供的接口
 * @Author 233loser
 * @Date 2019/6/8 17:43
 * @Version 1.0
 **/
public interface HallService4Order {

    /**
     * 根据id返回影厅名
     *
     * @param hallId 影厅编号
     * @return 对应的影厅名称
     */
    String getHallNameById(Long hallId);
}
