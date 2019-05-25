package org.seec.muggle.auror.po;


import lombok.Data;

import java.util.Date;

/**
 * @author fjj
 * @date 2019/3/23 1:12 PM
 */
@Data
public class Movie {
    //电影id
    private Integer id;
    //电影名称
    private String name;
    //海报url
    private String posterUrl;
    //导演
    private String directors; //"<name>:<url>..."
    //主演
    private String leadActors; //"<name>:<url>..."
    //电影类型
    private String type;
    //制片国家/地区
    private String country;
    //语言
    private String language;
    //上映时间
    private Date startDate;
    //观众可见日期
    private Date visibleDate;
    //片长 单位:分钟
    private Integer length;
    //电影版本 3D，2D等
    private String version;
    //电影描述
    private String description;
    //电影状态，0：未上映，1：上映中，2：已结束
    private Integer status;
}
