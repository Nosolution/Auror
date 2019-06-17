package org.seec.muggle.auror.bl.message;

import org.seec.muggle.auror.vo.user.message.MessageVO;

/**
 * @Description 业务逻辑层message模块接口
 * @Author jyh
 * @Date 2019/6/8 14:19
 * @Version 1.0
 **/
public interface MessageService {
    /**
     * @Author jyh
     * @Description //获取用户未读消息数
     * @Date 15:53 2019/6/8
     * @Param [userId]
     * @return int
     **/
    public int getUnreadNum(Long userId);

    /**
     * @Author jyh
     * @Description //获取用户的所有消息数 <0:未读><1:已读>
     * @Date 16:00 2019/6/8
     * @Param [userId]
     * @return org.seec.muggle.auror.vo.user.message.MessageVO[]
     **/
    public MessageVO[] getMessages(Long userId);
}
