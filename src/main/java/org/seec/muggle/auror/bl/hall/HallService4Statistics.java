package org.seec.muggle.auror.bl.hall;

/**
 * @Description hall模块为statistics模块提供的接口
 * @Author 233loser
 * @Date 2019/6/6 18:11
 * @Version 1.0
 **/
public interface HallService4Statistics {
    /**
     * 返回id对应影厅的总座位数量
     *
     * @param hallId 影厅编号
     * @return 总座位数量
     */
    int getSeatsNum(Long hallId);
}
