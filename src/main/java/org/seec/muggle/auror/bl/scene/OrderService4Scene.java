package org.seec.muggle.auror.bl.scene;

import org.seec.muggle.auror.po.TicketPO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 21:20
 * @Version 1.0
 **/
public interface OrderService4Scene {
    List<TicketPO> getTicketsBySceneId(Long sceneId);
}
