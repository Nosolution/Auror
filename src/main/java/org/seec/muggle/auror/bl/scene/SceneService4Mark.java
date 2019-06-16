package org.seec.muggle.auror.bl.scene;

import java.util.List;

/**
 * @Description scene模块为mark模块提供的接口
 * @Author 233loser
 * @Date 2019/6/7 18:39
 * @Version 1.0
 **/
public interface SceneService4Mark {

    /**
     * 获取电影的所有排片的id
     *
     * @param movieId 电影id
     * @return 排片id列表
     */
    List<Long> getSceneIdsByMovieId(Long movieId);
}
