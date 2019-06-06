package org.seec.muggle.auror.dao.order;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.OrderPO;
import org.seec.muggle.auror.po.TicketPO;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 11:58
 * @Version 1.0
 **/
@DaoMapper
public interface OrderMapper {
    @Options(keyProperty = "id")
    Long insertOrder(OrderPO po);

    int insertSeat(TicketPO po);

    int cancelOrder(@Param("orderId") Long orderId);

    OrderPO findOrderById(@Param("orderId")Long orderId);

    Integer orderNumsBySceneId(@Param("sceneId")Long sceneId);
}
