package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * 影厅类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/14
 */
@Data
public class Hall {
    //影厅id
    private Long id;
    //影厅名称
    private String name;
    //所有座位 0:不可用 1:可用
    private Integer[][] seats;
}
