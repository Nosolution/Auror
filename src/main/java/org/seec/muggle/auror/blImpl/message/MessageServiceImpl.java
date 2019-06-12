package org.seec.muggle.auror.blImpl.message;

import org.seec.muggle.auror.bl.account.AccountService4Message;
import org.seec.muggle.auror.bl.message.MessageService;
import org.seec.muggle.auror.bl.message.MessageService4Scene;
import org.seec.muggle.auror.bl.message.MessageService4Strategy;
import org.seec.muggle.auror.bl.statistics.MovieMarkService4Message;
import org.seec.muggle.auror.dao.message.MessageMapper;
import org.seec.muggle.auror.po.Message;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.user.brief_info.BriefInfoVO;
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
public class MessageServiceImpl implements MessageService , MessageService4Strategy, MessageService4Scene {
    @Autowired
    MessageMapper mapper;

    @Autowired
    AccountService4Message accountService4Message;

    @Autowired
    MovieMarkService4Message  movieMarkService4Message;

    @Override
    public int getUnreadNum(Long userId) {
        return mapper.getUnreadNums(userId);
    }

    @Override
    public MessageVO[] messages(Long userId) {
        List<Message> messages = mapper.getMessages(userId);
        mapper.readAll(userId);
        List<MessageVO> vos = new ArrayList<>();
        messages.forEach(o -> {
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
    public void SendMovieOnSceneRemind(Message message) {
        List<Long> users = movieMarkService4Message.getUsersByMovieId(message.getAdditionalMovieId());
        if(users.size()!=0){
            for(int i =0;i<users.size();i++){
                message.setUserId(users.get(i));
                mapper.insert(message);
            }
        }
    }

    /**
     * @Author jyh
     * @Description //赠送优惠券顺便送信息
     * @Date 16:06 2019/6/12
     * @Param [form]
     * @return void
     **/
    @Override
    public void sendCouponReceiversMessages(Message form, Long[] users) {
        for(int i = 0; i< users.length; i++){
            form.setUserId(users[i]);
            mapper.insert(form);
        }
    }


    @Override
    public void newEventRemind(Message message) {
        BriefInfoVO[] briefInfos = accountService4Message.getUsers();
        for(int i = 0;i< briefInfos.length;i++){
            message.setUserId(briefInfos[i].getUserId());
            mapper.insert(message);
        }
    }
}
