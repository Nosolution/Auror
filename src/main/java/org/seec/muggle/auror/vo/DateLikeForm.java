package org.seec.muggle.auror.vo;

import lombok.Data;

import java.sql.Date;

/**
 * Created by liying on 2019/3/23.
 */
@Data
public class DateLikeForm {
    /**
     * 喜爱人数
     */
    private int likeNum;

    /**
     * 喜爱时间
     */
    private Date likeTime;
}
