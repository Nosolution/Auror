package org.seec.muggle.auror.vo.seatselection;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:09
 * @Version 1.0
 **/
@Data
public class SeatsSelectionForm {
    Long sceneId;
    SelectionForm[] selectedSeats;
}
