package org.seec.muggle.auror.vo.movie.detail;

public class MovieDetailsVO {
    /**
     * 电影id
     */
    private Long movieId;
    /**
     * 电影名称
     */
    private String movieName;
    /**
     * 海报url
     */
    private String posterUrl;
    /**
     * 电影类型
     */
    private String movieType;
    /**
     * 电影年份
     */
    private Integer year;
    /**
     * 导演
     */
    private DirectorVO[] directors;
    /**
     * 主演
     */
    private StarringVO[] starrings;

    /**
     * 片长, 单位: min
     */
    private Integer length;
    /**
     * 得分
     */
    private Double score;

    public MovieDetailsVO(){

    }
    public MovieDetailsVO(Long movieId, String movieName, String posterUrl, String movieType, Integer year, Integer length, Double score) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.posterUrl = posterUrl;
        this.movieType = movieType;
        this.year = year;
        this.length = length;
        this.score = score;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public DirectorVO[] getDirector() {
        return directors;
    }

    public void setDirector(DirectorVO[] directors) {
        this.directors = directors;
    }

    public StarringVO[] getStarring() {
        return starrings;
    }

    public void setStarring(StarringVO[] starring) {
        this.starrings = starring;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
