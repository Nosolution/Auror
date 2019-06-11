package org.seec.muggle.auror.vo.order.unfinished;

import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.IntervalVO;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:41
 * @Version 1.0
 **/
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IntervalVO getInterval() {
        return interval;
    }

    public void setInterval(IntervalVO interval) {
        this.interval = interval;
    }

    public UnfinishedOrderSeatsVO[] getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(UnfinishedOrderSeatsVO[] selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public AvailableCouponsVO[] getAvailableCoupons() {
        return availableCoupons;
    }

    public void setAvailableCoupons(AvailableCouponsVO[] availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    public Timestamp getInitTime() {
        return initTime;
    }

    public void setInitTime(Timestamp initTime) {
        this.initTime = initTime;
    }

    public UnfinishedOrderVO(OrderPO orderPO, ScenePO scenePO, HallPO hallPO, List<TicketPO> ticketPOS, List<AvailableCouponsVO> couponPOS,String movieName) {
        this.orderId = orderPO.getId();
        this.movieName =movieName;
        this.hallName = hallPO.getHallName();
        this.ticketNum = ticketPOS.size();
        this.cost = scenePO.getPrice()*ticketPOS.size();
        this.date = DateUtil.dateToString(scenePO.getDate());
        this.interval = new IntervalVO(scenePO.getStartTime(),scenePO.getEndTime());
        this.selectedSeats = new UnfinishedOrderSeatsVO[ticketPOS.size()];
        for(int i =0;i<selectedSeats.length;i++){
            selectedSeats[i] = new UnfinishedOrderSeatsVO(ticketPOS.get(i).getRow(),ticketPOS.get(i).getColumn());
        }
        this.availableCoupons = couponPOS.toArray(new AvailableCouponsVO[couponPOS.size()]);
        this.initTime = orderPO.getCreateTime();
    }
}
