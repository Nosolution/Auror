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
    //指定的日期
    Date date;
    //总座位数量计算
    Integer seatCount;
    //总已被购买票数计算
    Integer ticketCount;


    public AttendInfo(Date date, Integer seatCount, Integer ticketCount) {
        this.date = date;
        this.seatCount = seatCount;
        this.ticketCount = ticketCount;
    }

    public AttendInfo() {

    }
}
