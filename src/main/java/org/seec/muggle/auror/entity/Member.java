package org.seec.muggle.auror.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    //会员信息
    private String info;
    //出生日期
    private Date birthday;
    //性别，0为女，1为男
    private Integer sex;
    //剩余金额
    private BigDecimal balance;
}
