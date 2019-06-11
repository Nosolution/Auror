package org.seec.muggle.auror.vo.order.unfinished;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:08
 * @Version 1.0
 **/
@Data
public class UnfinishedOrderSeatsVO {
    Integer row;
    Integer column;

    public UnfinishedOrderSeatsVO(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
}
