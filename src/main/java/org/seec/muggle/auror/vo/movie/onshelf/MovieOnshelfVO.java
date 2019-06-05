package org.seec.muggle.auror.vo.movie.onshelf;

import org.seec.muggle.auror.po.MoviePO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 16:23
 * @Version 1.0
 **/
public class MovieOnshelfVO {
    boolean isOnShow;
    Long movieId;
    String movieName;
    String movieType;
    Integer movieYear;
    Integer movieLengh;
    String posterUrl;

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean isOnShow() {
        return isOnShow;
    }

    public void setOnShow(boolean onShow) {
        isOnShow = onShow;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public Integer getMovieLengh() {
        return movieLengh;
    }

    public void setMovieLengh(Integer movieLengh) {
        this.movieLengh = movieLengh;
    }

    public MovieOnshelfVO(boolean isOnShow, Long movieId, String movieName, String movieType, Integer movieYear, Integer movieLengh) {
        this.isOnShow = isOnShow;
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieYear = movieYear;
        this.movieLengh = movieLengh;
    }

    public MovieOnshelfVO(MoviePO po,boolean isOnShow){
        this.movieId = po.getId();
        this.movieLengh = po.getLength();
        this.movieName = po.getMovieName();
        this.movieType = po.getMovieType();
        this.movieYear = po.getMovieYear();
        this.isOnShow = isOnShow;
        this.posterUrl = po.getPosterUrl();
    }
    public MovieOnshelfVO(){

    }
}
