package org.seec.muggle.auror.dao.message;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dao.BaseOperation;
import org.seec.muggle.auror.po.Message;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 20:22
 * @Version 1.0
 **/
@DaoMapper
public interface MessageMapper extends BaseOperation {
    List<Message> getMessages(Long userId);

    int getUnreadNums(Long userId);
}
