package org.seec.muggle.auror.vo.movie.detail;

import lombok.Data;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.util.DateConverterUtil;

@Data
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
    private String dateOnshow;
    private String visibleDate;
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

    public MovieDetailsVO() {

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


    public MovieDetailsVO(MoviePO po, int status, double score) {
        this.status = status;
        this.score = score;
        this.country = po.getCountry();
        this.movieName = po.getMovieName();
        this.description = po.getDescription();
        this.directors = new DirectorVO[po.getDirectors().size()];
        this.directors = po.getDirectors().toArray(directors);
        this.starrings = new StarringVO[po.getStarrings().size()];
        this.starrings = po.getStarrings().toArray(starrings);
        this.length = po.getLength();
        this.movieId = po.getId();
        this.language = po.getLanguage();
        this.movieType = po.getMovieType();
        this.posterUrl = po.getPosterUrl();
        this.year = po.getMovieYear();
        this.dateOnshow = DateConverterUtil.dateToString(po.getStartDate());
        this.visibleDate = DateConverterUtil.dateToString(po.getVisibleDate());
    }
}
