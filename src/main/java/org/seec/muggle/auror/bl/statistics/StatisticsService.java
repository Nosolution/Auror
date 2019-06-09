package org.seec.muggle.auror.bl.statistics;

import org.seec.muggle.auror.vo.movie.statistics.AttendenceVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 19:25
 * @Version 1.0
 **/
public interface StatisticsService {
    AttendenceVO[] getBoxOfficeRate(Long movieId);

    Integer getBoxOffice(Long movieId);
}
