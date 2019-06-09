package org.seec.muggle.auror.po;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 20:02
 * @Version 1.0
 **/
public class AttendInfo {
    Date date;
    Integer seats;
    Integer orders;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public AttendInfo(Date date, Integer seats, Integer orders) {
        this.date = date;
        this.seats = seats;
        this.orders = orders;
    }

    public AttendInfo() {

    }
}
