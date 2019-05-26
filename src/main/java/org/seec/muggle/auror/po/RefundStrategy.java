package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * 退票策略
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/5/12
 */
@Data
public class RefundStrategy {
    private Integer minDistanceToPlaying; //单位: 小时
    private Double refundRate;
}

