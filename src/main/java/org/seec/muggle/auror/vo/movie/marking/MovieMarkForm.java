package org.seec.muggle.auror.vo.movie.marking;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 16:27
 * @Version 1.0
 **/
public class MovieMarkForm {
    Long userId;
    Long movieId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
