package org.seec.muggle.auror.bl.message;

import org.seec.muggle.auror.po.Message;

/**
 * @Description 提供给Scene模块的信息模块
 * @Author jyh
 * @Date 2019/6/12 16:32
 * @Version 1.0
 **/
public interface MessageService4Scene {
    /**
     * @Author jyh
     * @Description //提供给SceneService的接口，用于提示用户想看电影已经上映
     * @Date 19:59 2019/6/12
     * @Param [message]
     * @return void
     **/
    public void sendMovieOnSceneRemind(Message message);
}
