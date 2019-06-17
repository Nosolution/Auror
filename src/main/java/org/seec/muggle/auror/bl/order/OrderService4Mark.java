package org.seec.muggle.auror.bl.order;

import java.util.List;

/**
 * @Description 提供给Mark服务的接口
 * @Author jyh
 * @Date 2019/6/7 18:48
 * @Version 1.0
 **/
public interface OrderService4Mark {

    /**
     * @Author jyh
     * @Description //判断用户是否看过某电影
     * @Date 20:19 2019/6/17
     * @Param [userId, sceneIds]
     * @return boolean
     **/
    boolean hasSeen(Long userId, List<Long> sceneIds);

}
