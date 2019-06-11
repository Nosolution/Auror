package org.seec.muggle.auror.po;

import lombok.Data;
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
@Data
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

    public MoviePO(MovieAddForm form) {
        this.country = form.getCountry();
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

    public MoviePO(MovieVaryForm form) {
        this.country = form.getCountry();
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
        this.id = form.getMovieId();
    }

    public MoviePO() {

    }
}
