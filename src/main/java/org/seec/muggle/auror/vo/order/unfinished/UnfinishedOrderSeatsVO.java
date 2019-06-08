package org.seec.muggle.auror.vo.order.unfinished;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:08
 * @Version 1.0
 **/
public class UnfinishedOrderSeatsVO {
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

    public UnfinishedOrderSeatsVO(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
}
