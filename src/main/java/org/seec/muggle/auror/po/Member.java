package org.seec.muggle.auror.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 会员类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class Member {
    //会员id
    private Long id;
    //用户id
    private Long userId;
    //所属的会员卡id
    private Long memberCardId;
    //图片url
    private String pictureUrl;
    //剩余金额
    private BigDecimal credit;
    //购票折扣率 (0,1)
    private Double discountRate;
}
