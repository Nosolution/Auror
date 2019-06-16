package org.seec.muggle.auror.vo.movie.onshelf;

import lombok.Data;
import org.seec.muggle.auror.po.MoviePO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 16:23
 * @Version 1.0
 **/
@Data
public class MovieOnShelfVO {
    public boolean getIsOnShow() {
        return isOnShow;
    }

    public void setIsOnShow(boolean isOnShow) {
        isOnShow = isOnShow;
    }

    boolean isOnShow;
    Long movieId;
    String movieName;
    String movieType;
    Integer movieYear;
    Integer movieLength;
    String posterUrl;


    public MovieOnShelfVO(MoviePO po, boolean isOnShow) {
        this.movieId = po.getId();
        this.movieLength = po.getLength();
        this.movieName = po.getMovieName();
        this.movieType = po.getMovieType();
        this.movieYear = po.getMovieYear();
        this.isOnShow = isOnShow;
        this.posterUrl = po.getPosterUrl();
    }

}
