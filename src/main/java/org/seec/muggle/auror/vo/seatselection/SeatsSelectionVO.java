package org.seec.muggle.auror.vo.seatselection;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:14
 * @Version 1.0
 **/
@Data
public class SeatsSelectionVO {
    Long orderId;
    Integer ticketNum;
    Integer cost;
    String initTime;

}
