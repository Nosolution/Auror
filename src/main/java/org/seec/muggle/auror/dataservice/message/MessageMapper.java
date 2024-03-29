package org.seec.muggle.auror.dataservice.message;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dataservice.BaseOperation;
import org.seec.muggle.auror.po.MessagePO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/8 20:22
 * @Version 1.0
 **/
@DaoMapper
public interface MessageMapper extends BaseOperation<MessagePO> {
    List<MessagePO> getMessages(Long userId);

    int getUnreadNums(Long userId);

    Integer readAll(Long userId);
}
