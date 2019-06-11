package org.seec.muggle.auror.dao.order;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.OrderPO;
import org.seec.muggle.auror.po.RechargePO;
import org.seec.muggle.auror.po.TicketPO;

import java.util.List;

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

    int deleteSeat(@Param("orderId")Long orderId);

    OrderPO getOrderById(@Param("orderId") Long orderId);

    Integer TicketNumsBySceneId(@Param("sceneId")Long sceneId);

    int insertMember (@Param("strategyId")Long strategyId,@Param("userId")Long userId,@Param("cost")Integer threshold);

    int insertRecharge(RechargePO po);

    OrderPO getOrderByUserIdAndSceneId(@Param("userId") Long userId, @Param("sceneId") Long sceneId);

    List<TicketPO> getSeatsById(Long orderId);

    List<TicketPO> getSeatsBySceneId(Long sceneId);

    Integer sumBoxOffice(Long movieId);

    Integer sumRecharge(Long userId);

    List<RechargePO> selectRechargesById(Long userId);

    Integer getAllPayment(@Param("userId")Long userId);

    int finishOrder(@Param("orderId")Long orderId,@Param("cost")Integer paymeny,@Param("method")Integer method);

    List<OrderPO> getAllOrdersByUser(Long userId);
}
