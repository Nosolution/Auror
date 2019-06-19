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
    //电影id
    Long id;
    //电影名称
    String movieName;
    //电影简介
    String description;
    // 排片信息观众可见时间
    Date visibleDate;
    //上映时间
    Date startDate;
    //下映时间
    Date endDate;
    //海报url
    String posterUrl;
    //电影类型
    String movieType;
    //制作地区
    String country;
    //使用语言
    String language;
    //时长
    Integer length;
    //电影年份
    Integer movieYear;
    //导演
    List<DirectorVO> directors;
    //主演
    List<StarringVO> starrings;
    //电影状态 <1:未上映>, <2:已上映>, <3:已下架>
    Integer status;


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
