package org.seec.muggle.auror.bl.strategy;

import org.seec.muggle.auror.po.Message;

/**
 * @Description 提供给Strategy模块的信息模块
 * @Author jyh
 * @Date 2019/6/12 16:04
 * @Version 1.0
 **/
public interface MessageService4Strategy {
    /**
     * @return void
     * @Author jyh
     * @Description //当管理员赠送优惠券给用户时，用户获取新的消息<0:获取优惠券
     * @Date 20:00 2019/6/12
     * @Param [message, userIds]
     **/
    public void sendCouponReceiversMessages(Message message, Long[] userIds);

    /**
     * @return void
     * @Author jyh
     * @Description //当管理员发布新的优惠活动时，用户获取新的消息<4: 新的优惠活动>
     * @Date 20:32 2019/6/12
     * @Param [message]
     **/
    public void broadcastNewEvent(Message message);
}
