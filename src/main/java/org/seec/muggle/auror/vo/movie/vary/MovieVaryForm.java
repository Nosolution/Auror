package org.seec.muggle.auror.vo.movie.vary;

import org.seec.muggle.auror.vo.movie.detail.DirectorVO;
import org.seec.muggle.auror.vo.movie.detail.StarringVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:43
 * @Version 1.0
 **/
public class MovieVaryForm {
    String movieName;
    String description;
    String visibleDate; // 排片信息观众可见时间
    String startDate;
    String endDate;
    String posterUrl;
    String movieType;
    String country;
    String language;
    Integer length; //时长
    /**
     * 导演
     */
    DirectorVO[] directors;
    /**
     * 主演
     */
    StarringVO[] starrings;

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

    public String getVisibleDate() {
        return visibleDate;
    }

    public void setVisibleDate(String visibleDate) {
        this.visibleDate = visibleDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
