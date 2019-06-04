package org.seec.muggle.auror.vo.movie.detail;

import org.seec.muggle.auror.po.MoviePO;

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

    private String country;
    private String language;
    private String description;
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

    private int status;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DirectorVO[] getDirectors() {
        return directors;
    }

    public void setDirectors(DirectorVO[] directors) {
        this.directors = directors;
    }

    public StarringVO[] getStarrings() {
        return starrings;
    }

    public void setStarrings(StarringVO[] starrings) {
        this.starrings = starrings;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public MovieDetailsVO(MoviePO po,int status){
        this.status = status;
        this.score = score;
        this.country = po.getCountry();
        this.movieName = po.getMovieName();
        this.description = po.getDescription();
        this.directors = new DirectorVO[po.getDirectors().size()];
        this.directors  = po.getDirectors().toArray(directors);
        this.starrings = new StarringVO[po.getStarrings().size()];
        this.starrings = po.getStarrings().toArray(starrings);
        this.length = po.getLength();
        this.movieId = po.getId();
        this.language = po.getLanguage();
        this.movieType = po.getMovieType();
        this.posterUrl = po.getPosterUrl();
        this.year = po.getMovieYear();

    }
}
