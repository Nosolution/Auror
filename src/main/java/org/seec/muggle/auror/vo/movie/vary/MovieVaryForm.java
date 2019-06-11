package org.seec.muggle.auror.vo.movie.vary;

import lombok.Data;
import org.seec.muggle.auror.vo.movie.detail.DirectorVO;
import org.seec.muggle.auror.vo.movie.detail.StarringVO;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 22:43
 * @Version 1.0
 **/
@Data
public class MovieVaryForm {
    Long movieId;
    String movieName;
    String description;
    Date visibleDate; // 排片信息观众可见时间
    Date startDate;
    Date endDate;
    String posterUrl;
    String movieType;
    String country;
    Integer movieYear;
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

}
