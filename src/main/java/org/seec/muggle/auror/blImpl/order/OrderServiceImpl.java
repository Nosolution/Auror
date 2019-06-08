package org.seec.muggle.auror.blImpl.order;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.seec.muggle.auror.bl.order.OrderService;
import org.seec.muggle.auror.bl.order.OrderService4Mark;
import org.seec.muggle.auror.bl.order.OrderService4Statistics;
import org.seec.muggle.auror.bl.scene.SceneService4Order;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.order.OrderMapper;
import org.seec.muggle.auror.po.OrderPO;
import org.seec.muggle.auror.po.RefundPO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.po.TicketPO;
import org.seec.muggle.auror.util.CaptchaUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 12:00
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService, OrderService4Statistics, OrderService4Mark {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    SceneService4Order sceneService4Order;

    @Autowired
    StrategyService4Order strategyService4Order;

    @Override
    public SeatsSelectionVO selectSeats(Long sceneId, Long userId, SelectionForm[] selectedSeats) {

        SeatsSelectionVO vo = new SeatsSelectionVO();

        OrderPO po = new OrderPO();
        po.setCode(CaptchaUtil.getCaptcha());
        po.setUserId(userId);
        po.setCreateTime(new Timestamp(System.currentTimeMillis()));
        po.setSceneId(sceneId);
        po.setStatus(0);
        Integer cost = selectedSeats.length*sceneService4Order.getPriceByScene(sceneId);
        po.setCost(cost);

        orderMapper.insertOrder(po);

        for(int i =0 ;i<selectedSeats.length;i++){
            orderMapper.insertSeat(new TicketPO(sceneId,selectedSeats[i].getRow(),selectedSeats[i].getColumn()));
        }

        vo.setOrderId(po.getId());
        vo.setInitTime(po.getCreateTime());
        vo.setTicketNum(selectedSeats.length);
        vo.setCost(cost);
        return vo;
    }

    @Override
    public BasicVO cancelOrder(Long orderId) {
        orderMapper.cancelOrder(orderId);
        return  new BasicVO();
    }

    @Override
    public Double refundOrder(Long orderId) {
        Integer cost = orderMapper.findOrderById(orderId).getCost();
        RefundPO refundStrategy = strategyService4Order.getRefund();
        Double amount =refundStrategy.getRate()*new Double((double)cost);
        orderMapper.cancelOrder(orderId);
        return amount;
    }

    @Override
    public int getNumsBySceneId(Long sceneId) {
        return orderMapper.orderNumsBySceneId(sceneId);
    }

    @Override
    public BasicVO purchaseMember(Long userId, Integer cost, Long memberId) {
        orderMapper.insertMember(memberId,userId,cost);
        return new BasicVO();
    }

    @Override
    public int hasSeen(Long userId, List<ScenePO> sceneId) {
        for(int i =0;i<sceneId.size();i++){
            if (orderMapper.findOrderByUserIdAndSceneId(userId,sceneId.get(i).getId())!=null){
                return 1;
            }
        }
        return 0;
    }
}
