package org.seec.muggle.auror.vo.user.mark;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 21:46
 * @Version 1.0
 **/
public class MovieMarkVO {
    String posterUrl;
    Long movieId; // 电影Id
    String movieName;// 电影名称
    String movieType;// 电影类别（动作片）
    Integer movieYear;// 电影年份
    Integer movieLength;// 电影时长
    String movieDescription;// 电影简介
    Integer userStatus; //<1: 已看过>, <2: 未看>
    Integer movieStatus; //<1: 未上映>, <2: 已上映>, <3: 已下架>


    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
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

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(Integer movieStatus) {
        this.movieStatus = movieStatus;
    }
}
