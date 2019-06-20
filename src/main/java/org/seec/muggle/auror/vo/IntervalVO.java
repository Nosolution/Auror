package org.seec.muggle.auror.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.seec.muggle.auror.util.DateConverterUtil;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/31 11:36
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class IntervalVO {
    String startTime;
    String endTime;

    public IntervalVO(Timestamp startTime, Timestamp endTime) {

        this.startTime = DateConverterUtil.timestampToTimeString(startTime);
        this.endTime = DateConverterUtil.timestampToTimeString(endTime);
    }

}
