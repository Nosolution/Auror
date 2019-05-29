package org.seec.muggle.auror.vo.movie.comment;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:36
 * @Version 1.0
 **/
public class CommentForm {
    Long movieId;
    Integer rate; //评分0-10
    String comment;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
