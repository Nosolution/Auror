package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;

import java.time.LocalTime;
import java.util.Date;

/**
 * @Description 业务逻辑层scene模块接口
 * @Author 233loser
 * @Date 2019/6/4 21:23
 * @Version 1.0
 **/
public interface SceneService {
    /**
     * 新增排片
     *
     * @param movieId   电影id
     * @param hallName  影厅名称
     * @param date      日期
     * @param startTime 放映开始时间
     * @param price     价格
     */
    void addScene(Long movieId, String hallName, Date date, LocalTime startTime, int price);


    /**
     * 修改排片信息
     *
     * @param sceneId   排片id
     * @param hallName  影厅名称
     * @param date      日期
     * @param startTime 放映开始时间
     * @param price     价格
     */
    void updateScene(Long sceneId, String hallName, Date date, LocalTime startTime, int price);

    /**
     * 删除排片
     *
     * @param sceneId 排片id
     */
    void deleteScene(Long sceneId);

    /**
     * 获取电影的所有排片信息
     *
     * @param movieId 电影id
     * @return 对应电影的所有排片信息
     */
    MovieSceneInfoVO[] getScenesInfoByMovieId(Long movieId);

    /**
     * 获取某影厅与某日的所有排片信息
     *
     * @param hallName 影厅名称
     * @param date     日期
     * @return 所有排片信息
     */
    InfoVO[] getScenesInfoByHallNameAndDate(String hallName, Date date);
}
