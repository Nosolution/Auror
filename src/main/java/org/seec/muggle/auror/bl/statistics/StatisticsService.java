package org.seec.muggle.auror.bl.statistics;

import org.seec.muggle.auror.vo.movie.statistics.AttendenceVO;

/**
 * @Description 数据模块的接口
 * @Author jyh
 * @Date 2019/6/6 19:25
 * @Version 1.0
 **/
public interface StatisticsService {
    /**
     * @Author jyh
     * @Description // 获取某部电影的的上座率，以天区分
     * @Date 20:26 2019/6/6
     * @Param [movieId]
     * @return org.seec.muggle.auror.vo.movie.statistics.AttendenceVO[]
     **/
    AttendenceVO[] getBoxOfficeRate(Long movieId);

    /**
     * @Author jyh
     * @Description //获取某部电影的累计票房
     * @Date 22:01 2019/6/6
     * @Param [movieId]
     * @return java.lang.Integer
     **/
    Integer getBoxOffice(Long movieId);
}
