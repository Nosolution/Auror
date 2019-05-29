package org.seec.muggle.auror.vo.seatselection;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:14
 * @Version 1.0
 **/
public class SeatsSelectionVO {
    Long orderId;
    Integer ticketNum;
    Integer cost;
    String initTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }
}
