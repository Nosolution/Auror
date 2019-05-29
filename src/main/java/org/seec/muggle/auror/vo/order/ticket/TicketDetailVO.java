package org.seec.muggle.auror.vo.order.ticket;

import org.seec.muggle.auror.vo.seatselection.SelectionForm;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:30
 * @Version 1.0
 **/
public class TicketDetailVO {
    Long orderId;
    String movieName;
    String moviePosterUrl;
    String hallName;
    String date;
    String interval;
    Integer status; //0: 未完成 1: 已完成 2: 已失效
    Integer cost;
    String ticketCode;//取票码
    SelectionForm[] selectedSeats;
    Integer ticketNum;
    String initTime;

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

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public SelectionForm[] getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(SelectionForm[] selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }
}
