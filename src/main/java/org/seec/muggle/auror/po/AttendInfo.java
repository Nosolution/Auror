package org.seec.muggle.auror.po;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 20:02
 * @Version 1.0
 **/
@Data
public class AttendInfo {
    Date date;
    Integer seats;
    Integer orders;


    public AttendInfo(Date date, Integer seats, Integer orders) {
        this.date = date;
        this.seats = seats;
        this.orders = orders;
    }

    public AttendInfo() {

    }
}
