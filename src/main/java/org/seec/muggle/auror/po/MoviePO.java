package org.seec.muggle.auror.po;

import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.detail.DirectorVO;
import org.seec.muggle.auror.vo.movie.detail.StarringVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/3 20:43
 * @Version 1.0
 **/
public class MoviePO {
    Long id;
    String movieName;
    String description;
    Date visibleDate; // 排片信息观众可见时间
    Date startDate;
    Date endDate;
    String posterUrl;
    String movieType;
    String country;
    String language;
    Integer length; //时长
    Integer movieYear;
    List<DirectorVO> directors;
    Integer status;
    /**
     * 主演
     */
    List<StarringVO> starrings;

    public List<DirectorVO> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorVO> directors) {
        this.directors = directors;
    }

    public List<StarringVO> getStarrings() {
        return starrings;
    }

    public void setStarrings(List<StarringVO> starrings) {
        this.starrings = starrings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVisibleDate() {
        return visibleDate;
    }

    public void setVisibleDate(Date visibleDate) {
        this.visibleDate = visibleDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public MoviePO(MovieAddForm form){
        this.country=form.getCountry();
        this.description = form.getDescription();
        this.endDate = form.getEndDate();
        this.language = form.getLanguage();
        this.length = form.getLength();
        this.startDate = form.getStartDate();
        this.visibleDate = form.getVisibleDate();
        this.movieName = form.getMovieName();
        this.movieType = form.getMovieType();
        this.posterUrl = form.getPosterUrl();
        this.movieYear = form.getMovieYear();
    }
    public MoviePO(MovieVaryForm form){
        this.country=form.getCountry();
        this.description = form.getDescription();
        this.endDate = form.getEndDate();
        this.language = form.getLanguage();
        this.length = form.getLength();
        this.startDate = form.getStartDate();
        this.visibleDate = form.getVisibleDate();
        this.movieName = form.getMovieName();
        this.movieType = form.getMovieType();
        this.posterUrl = form.getPosterUrl();
        this.movieYear = form.getMovieYear();
        this.id =form.getMovieId();
    }

    public MoviePO(){

    }
}
