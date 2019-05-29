package org.seec.muggle.auror.vo.order.unfinished;

import org.seec.muggle.auror.vo.seatselection.UnfinishedOrderSeatsVO;

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
    String interval;
    UnfinishedOrderSeatsVO[] selectedSeats;
    AvailableCouponsVO[] availableCoupons;
    String initTime;//生成订单时间

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

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
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

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }
}
