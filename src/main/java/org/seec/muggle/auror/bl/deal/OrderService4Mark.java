package org.seec.muggle.auror.bl.deal;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 18:48
 * @Version 1.0
 **/
public interface OrderService4Mark {

    boolean hasSeen(Long userId, List<Long> sceneIds);

}
