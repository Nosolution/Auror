package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.entity.order.Ticket4Scene;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 21:20
 * @Version 1.0
 **/
public interface OrderService4Scene {
    /**
     * 根据指定排片的所有售出电影票
     *
     * @param sceneId 排片id
     * @return 所有已售出的电影票
     */
    List<Ticket4Scene> getSoldTicketsBySceneId(Long sceneId);

    int getSoldSeatsNumBySceneId(Long sceneId);
}
