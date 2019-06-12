package org.seec.muggle.auror.bl.message;

import org.seec.muggle.auror.vo.MessageForm;
import org.seec.muggle.auror.vo.user.message.MessageVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 20:19
 * @Version 1.0
 **/
public interface MessageService {
    public int getUnreadNum(Long userId);

    public MessageVO[] messages(Long userId);

    public void sendMessages(MessageForm form);
}
