package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 14:32
 * @Version 1.0
 **/
public class TicketPO {
    Long sceneId;
    Integer row;
    Integer column;

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

    public TicketPO(){

    }

    public TicketPO(Long sceneId, Integer row, Integer column) {
        this.sceneId = sceneId;
        this.row = row;
        this.column = column;
    }
}
