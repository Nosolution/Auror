package org.seec.muggle.auror.bl.movie;

/**
 * @Description account模块为movie模块提供的接口
 * @Author 233loser
 * @Date 2019/6/5 19:42
 * @Version 1.0
 **/
public interface AccountService4Movie {

    /**
     * 根据用户id获取用户名
     *
     * @param userId 用户id
     * @return 用户民
     */
    String getUsernameById(Long userId);
}
