package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 22:25
 * @Version 1.0
 **/
@Data
public class MovieBoxOfficeMap {
    //电影id
    Long movieId;
    //电影票房
    Integer boxOffice;
}
