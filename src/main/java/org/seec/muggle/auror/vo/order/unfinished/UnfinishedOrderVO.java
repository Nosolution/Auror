package org.seec.muggle.auror.vo.order.unfinished;

import lombok.Data;
import org.seec.muggle.auror.entity.scene.Scene;
import org.seec.muggle.auror.po.OrderPO;
import org.seec.muggle.auror.po.TicketPO;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.IntervalVO;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:41
 * @Version 1.0
 **/
@Data
public class UnfinishedOrderVO {
    Long orderId;
    String movieName;
    String hallName;
    Integer ticketNum;
    Integer cost;
    String date;
    IntervalVO interval;
    UnfinishedOrderSeatsVO[] selectedSeats;
    AvailableCouponsVO[] availableCoupons;
    Timestamp initTime;//生成订单时间

    public UnfinishedOrderVO(OrderPO orderPO, Scene scene, String hallName, List<TicketPO> ticketPOS, List<AvailableCouponsVO> couponPOS, String movieName) {
        this.orderId = orderPO.getId();
        this.movieName =movieName;
        this.hallName = hallName;
        this.ticketNum = ticketPOS.size();
        this.cost = scene.getPrice() * ticketPOS.size();
        this.date = DateUtil.dateToString(scene.getDate());
        this.interval = new IntervalVO(scene.getStartTime(), scene.getEndTime());
        this.selectedSeats = new UnfinishedOrderSeatsVO[ticketPOS.size()];
        for(int i =0;i<selectedSeats.length;i++){
            selectedSeats[i] = new UnfinishedOrderSeatsVO(ticketPOS.get(i).getRow(),ticketPOS.get(i).getColumn());
        }
        this.availableCoupons = couponPOS.toArray(new AvailableCouponsVO[couponPOS.size()]);
        this.initTime = orderPO.getCreateTime();
    }
}
