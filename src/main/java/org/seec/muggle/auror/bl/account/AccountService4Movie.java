package org.seec.muggle.auror.bl.account;

import org.seec.muggle.auror.po.UserBasic;

/**
 * @Description account模块为movie模块提供的接口
 * @Author 233loser
 * @Date 2019/6/5 19:42
 * @Version 1.0
 **/
public interface AccountService4Movie {

    UserBasic getUserBasicInfoById(Long userId);
}
