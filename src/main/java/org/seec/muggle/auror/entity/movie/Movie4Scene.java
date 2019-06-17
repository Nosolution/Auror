package org.seec.muggle.auror.entity.movie;

import lombok.Data;

/**
 * 为scene模块提供的电影信息类
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/17
 */
@Data
public class Movie4Scene {
    private String movieName;
    private String posterUrl;
    private Integer length;
    private Integer status;
}
