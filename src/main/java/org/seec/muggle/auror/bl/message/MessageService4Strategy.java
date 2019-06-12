package org.seec.muggle.auror.bl.message;

import org.seec.muggle.auror.po.Message;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/12 16:04
 * @Version 1.0
 **/
public interface MessageService4Strategy {
    public void sendCouponReceiversMessages(Message message, Long[] userIds);

    public void newEventRemind(Message message);
}
