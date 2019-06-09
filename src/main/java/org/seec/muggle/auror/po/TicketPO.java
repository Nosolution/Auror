package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * @Description 新增OrderId，建立关系
 * @Author 233loser
 * @Date 2019/6/8 14:32
 * @Version 1.0
 **/
@Data
public class TicketPO {
    Long sceneId;
    Integer row;
    Integer column;
    Long orderId;

    public TicketPO() {

    }

    public TicketPO(Long sceneId, Integer row, Integer column) {
        this.sceneId = sceneId;
        this.row = row;
        this.column = column;
    }
}
