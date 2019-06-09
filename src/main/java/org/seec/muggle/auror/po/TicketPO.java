package org.seec.muggle.auror.po;

/**
 * @Description 新增OrderId，建立关系
 * @Author 233loser
 * @Date 2019/6/8 14:32
 * @Version 1.0
 **/
public class TicketPO {
    Long sceneId;
    Integer row;
    Integer column;
    Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public TicketPO() {

    }

    public TicketPO(Long sceneId, Integer row, Integer column) {
        this.sceneId = sceneId;
        this.row = row;
        this.column = column;
    }
}
