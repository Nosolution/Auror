package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * simple introduction
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/5/12
 */
@Data
public class MemberCard {
    private Long id;
    private String name;
    private String pictureUrl;
    private BigDecimal price;
    private Double discountRate;
}
