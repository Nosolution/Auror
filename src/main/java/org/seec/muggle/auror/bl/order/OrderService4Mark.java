package org.seec.muggle.auror.bl.order;

import org.seec.muggle.auror.po.ScenePO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 18:48
 * @Version 1.0
 **/
public interface OrderService4Mark {

    int hasSeen(Long userId, List<ScenePO> sceneId);

}
