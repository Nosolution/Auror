package org.seec.muggle.auror.bl.order;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 12:00
 * @Version 1.0
 **/
public interface OrderService {

    SeatsSelectionVO selectSeats(Long sceneId, Long userId, SelectionForm[] selectedSeats);

    BasicVO cancelOrder(Long orderId);

    Double refundOrder(Long orderId);

}
