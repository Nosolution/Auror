package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 18:14
 * @Version 1.0
 **/
public class HallPO {
    Long hallId;
    String hallName;
    String seats;

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
    public HallPO(){

    }
}
