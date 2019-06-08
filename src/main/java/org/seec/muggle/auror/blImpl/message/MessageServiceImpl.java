package org.seec.muggle.auror.blImpl.message;

import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.dao.message.MessageMapper;
import org.seec.muggle.auror.po.Message;
import org.seec.muggle.auror.vo.user.message.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 20:21
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper mapper;

    @Override
    public int getUnreadNum(Long userId) {
        return  mapper.getUnreadNums(userId);
    }

    @Override
    public MessageVO[] messages(Long userId) {
        List<Message> messages = mapper.getMessages(userId);
        List<MessageVO> vos = new ArrayList<>();
        messages.stream().forEach(o->{
            MessageVO message = new MessageVO();
            message.setMessageContent(o.getContent());
            message.setAdditionalMovieId(o.getAdditionalMovieId());
            message.setInitTime(o.getInitTime());
            message.setMessageStatus(o.getStatus());
            message.setMessageTitle(o.getTitle());
            message.setMessageType(o.getType());
            vos.add(message);
        });
        return vos.toArray(new MessageVO[vos.size()]);
    }
}
