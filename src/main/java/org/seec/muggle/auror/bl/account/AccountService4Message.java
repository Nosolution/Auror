package org.seec.muggle.auror.bl.account;

import java.util.List;

/**
 * @Description account模块为message模块提供的接口
 * @Author 233loser
 * @Date 2019/6/12 14:54
 * @Version 1.0
 **/
public interface AccountService4Message {

    /**
     * 获取所有用户的id
     */
    List<Long> getAllUserId();
}
