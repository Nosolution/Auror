package org.seec.muggle.auror.entity.movie;

import lombok.Data;

/**
 * 为moviemark模块提供的电影信息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/17
 */
@Data
public class Movie4Mark {
    private Long id;
    private String movieName;
    private String posterUrl;
    private String description;
    private Integer length;
    private Integer movieYear;
    private String movieType;
    private Integer status;
}
