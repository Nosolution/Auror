package org.seec.muggle.auror.vo.movie.addition;

import org.seec.muggle.auror.vo.movie.detail.DirectorVO;
import org.seec.muggle.auror.vo.movie.detail.StarringVO;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:43
 * @Version 1.0
 **/
public class MovieAddForm {
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
    /**
     * 导演
     */
    DirectorVO[] directors;
    /**
     * 主演
     */
    StarringVO[] starrings;

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
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
}
