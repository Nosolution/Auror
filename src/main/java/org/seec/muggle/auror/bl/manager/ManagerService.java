package org.seec.muggle.auror.bl.manager;

import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;

/**
 * @Description 业务逻辑排片经理管理模块
 * @Author jyh
 * @Date 2019/6/7 14:26
 * @Version 1.0
 **/
public interface ManagerService {

    /**
     * @Author jyh
     * @Description //新增一个管理员
     * @Date 19:42 2019/6/17
     * @Param [username, password]
     * @return void
     **/
    void addManager(String username, String password);

    /**
     * @Author jyh
     * @Description //删除管理员
     * @Date 19:43 2019/6/17
     * @Param [managerId]
     * @return void
     **/
    void deleteManager(Long managerId);

    /**
     * @Author jyh
     * @Description //获取所有管理员
     * @Date 19:43 2019/6/17
     * @Param []
     * @return org.seec.muggle.auror.vo.personnel.ManagerInfoVO[]
     **/
    ManagerInfoVO[] getManagers();
}
