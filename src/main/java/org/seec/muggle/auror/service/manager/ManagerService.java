package org.seec.muggle.auror.service.manager;

import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;

/**
 * @Description 业务逻辑排片经理管理模块
 * @Author jyh
 * @Date 2019/6/7 14:26
 * @Version 1.0
 **/
public interface ManagerService {

    /**
     * @return void
     * @Author jyh
     * @Description //新增一个管理员
     * @Date 19:42 2019/6/17
     * @Param [username, password]
     **/
    void addManager(String username, String password);

    /**
     * @return void
     * @Author jyh
     * @Description //删除管理员
     * @Date 19:43 2019/6/17
     * @Param [managerId]
     **/
    void deleteManager(Long managerId);

    /**
     * @return org.seec.muggle.auror.vo.personnel.ManagerInfoVO[]
     * @Author jyh
     * @Description //获取所有管理员
     * @Date 19:43 2019/6/17
     * @Param []
     **/
    ManagerInfoVO[] getManagers();
}
