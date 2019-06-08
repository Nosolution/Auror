package org.seec.muggle.auror.vo.order.ticket;

import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.vo.IntervalVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    Date date;
    IntervalVO interval;
    Integer status; //0: 未完成 1: 已完成 2: 已失效
    Integer cost;
    String ticketCode;//取票码
    SelectionForm[] selectedSeats;
    Integer ticketNum;
    Timestamp initTime;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IntervalVO getInterval() {
        return interval;
    }

    public void setInterval(IntervalVO interval) {
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

    public Timestamp getInitTime() {
        return initTime;
    }

    public void setInitTime(Timestamp initTime) {
        this.initTime = initTime;
    }

    public TicketDetailVO(ScenePO scene, MoviePO movie, int status, List<TicketPO> ticketPOS, OrderPO order, HallPO hall) {
        this.orderId = order.getId();
        this.movieName = movie.getMovieName();
        this.moviePosterUrl = movie.getPosterUrl();
        this.hallName = hall.getHallName();
        this.date = scene.getDate();
        this.interval = new IntervalVO(scene.getStartTime(),scene.getEndTime());
        this.status = status;
        this.cost = order.getCost();
        this.ticketCode = order.getCode();
        this.selectedSeats = new SelectionForm[ticketPOS.size()];
        for(int i = 0;i<selectedSeats.length;i++){
            selectedSeats[i] = new SelectionForm();
            selectedSeats[i].setRow(ticketPOS.get(i).getRow());
            selectedSeats[i].setColumn(ticketPOS.get(i).getColumn());
        }
        this.ticketNum = ticketPOS.size();
        this.initTime = order.getCreateTime();
    }
}
