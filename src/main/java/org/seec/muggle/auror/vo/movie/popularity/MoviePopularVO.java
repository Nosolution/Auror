package org.seec.muggle.auror.vo.movie.popularity;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 11:53
 * @Version 1.0
 **/
@Data
public class MoviePopularVO {
    String posterUrl;
    Long movieId;
    String movieName;
    String movieType;
    Integer movieYear;
    Integer movieLength;
    String movieDescription;

}
