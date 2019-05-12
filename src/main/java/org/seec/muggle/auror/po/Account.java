package org.seec.muggle.auror.po;

import lombok.Data;

import java.util.Date;

/**
 * 账号基本信息, 在目前来说大概用不到
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/20
 */
@Data
public class Account {
    //id, 与User类的id一致
    private Long id;
    //用户名
    private String username;
    //用户真实姓名
    private String name;
    //性别，0为女，1为男
    private Integer sex;
    //出生日期
    private Date birthday;
}
