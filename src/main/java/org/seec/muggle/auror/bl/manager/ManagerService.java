package org.seec.muggle.auror.bl.manager;

import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 14:26
 * @Version 1.0
 **/
public interface ManagerService {

    BasicVO addManager(String username,String password);

    BasicVO deleteManager(Long managerId);

    ManagerInfoVO[] getManagers();
}
