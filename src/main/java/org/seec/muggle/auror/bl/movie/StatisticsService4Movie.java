package org.seec.muggle.auror.bl.movie;

/**
 * 为movie模块提供的信息接口
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/19
 */
public interface StatisticsService4Movie {

    /**
     * 获取电影但目前为止的票房
     *
     * @param movieId 电影id
     * @return 电影票房
     */
    Integer getBoxOffice(Long movieId);
}
