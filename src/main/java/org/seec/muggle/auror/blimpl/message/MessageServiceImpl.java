package org.seec.muggle.auror.blimpl.message;

import org.seec.muggle.auror.bl.account.AccountService4Message;
import org.seec.muggle.auror.bl.mark.MovieMarkService4Message;
import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.bl.scene.MessageService4Scene;
import org.seec.muggle.auror.bl.strategy.MessageService4Strategy;
import org.seec.muggle.auror.dao.message.MessageMapper;
import org.seec.muggle.auror.entity.message.Message;
import org.seec.muggle.auror.po.MessagePO;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.user.message.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 20:21
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService, MessageService4Strategy, MessageService4Scene {
    @Autowired
    MessageMapper mapper;

    @Autowired
    AccountService4Message accountService4Message;

    @Autowired
    MovieMarkService4Message movieMarkService4Message;

    @Override
    public int getUnreadNum(Long userId) {
        return mapper.getUnreadNums(userId);
    }

    @Override
    public MessageVO[] getMessages(Long userId) {
        List<MessagePO> messagePOS = mapper.getMessages(userId);
        mapper.readAll(userId);
        List<MessageVO> vos = new ArrayList<>();
        messagePOS.stream().sorted(Comparator.comparing(MessagePO::getInitTime).reversed()).forEach(o -> {
            MessageVO message = new MessageVO();
            message.setMessageContent(o.getContent());
            message.setAdditionalMovieId(o.getAdditionalMovieId());
            message.setInitTime(DateUtil.timestampToString(o.getInitTime()));
            message.setMessageStatus(o.getStatus());
            message.setMessageTitle(o.getTitle());
            message.setMessageType(o.getType());
            vos.add(message);
        });
        return vos.toArray(new MessageVO[vos.size()]);
    }

    @Override
    public void sendMovieOnSceneRemind(Message message) {
        List<Long> users = movieMarkService4Message.getUsersByMovieId(message.getAdditionalMovieId());
        if (users.size() != 0) {
            for (Long user : users) {
                message.setUserId(user);
                mapper.insert(new MessagePO(message));
            }
        }
    }

    /**
     * @return void
     * @Author jyh
     * @Description //赠送优惠券顺便送信息
     * @Date 16:06 2019/6/12
     * @Param [form]
     **/
    @Override
    public void sendCouponReceiversMessages(MessagePO form, Long[] users) {
        for (Long user : users) {
            form.setUserId(user);
            mapper.insert(form);
        }
    }


    @Override
    public void broadcastNewEvent(MessagePO messagePO) {
        accountService4Message.getAllUserId()
                .forEach(o -> {
                    messagePO.setUserId(o);
                    mapper.insert(messagePO);
                });
    }
}
