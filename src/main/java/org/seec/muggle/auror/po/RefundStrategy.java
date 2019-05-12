package org.seec.muggle.auror.po;

import lombok.Data;

import java.time.Duration;

/**
 * 退票策略
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/5/12
 */
@Data
public class RefundStrategy {
    private Duration minDistanceToPlaying;
    private Double refundRate;
}

