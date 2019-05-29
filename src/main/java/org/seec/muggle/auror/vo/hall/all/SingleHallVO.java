package org.seec.muggle.auror.vo.hall.all;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:07
 * @Version 1.0
 **/
public class SingleHallVO {
    String hallName;
    Integer[][] seats;//0代表不可用，1代表可用

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer[][] getSeats() {
        return seats;
    }

    public void setSeats(Integer[][] seats) {
        this.seats = seats;
    }
}
