package org.seec.muggle.auror.bl.mark;

import java.util.List;

/**
 * @Description TODO
 * @Author jyh
 * @Date 2019/6/12 20:31
 * @Version 1.0
 **/
public interface MovieMarkService4Message {
    /**
     * @return java.util.List<java.lang.Long>
     * @Author jyh
     * @Description //提供给MessageService的接口，获取想看电影的用户
     * @Date 21:51 2019/6/12
     * @Param [movieId]
     **/
    public List<Long> getUsersByMovieId(Long movieId);
}
