package org.seec.muggle.auror.bl.manager;

import org.seec.muggle.auror.dataservice.account.RoleMapper;
import org.seec.muggle.auror.dataservice.account.UserMapper;
import org.seec.muggle.auror.dataservice.account.UserRoleMapper;
import org.seec.muggle.auror.dataservice.manager.ManagerMapper;
import org.seec.muggle.auror.po.User;
import org.seec.muggle.auror.service.manager.ManagerService;
import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 14:27
 * @Version 1.0
 **/
@Service
public class ManagerServiceImpl implements ManagerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public void addManager(String username, String password) {
        addNewManager(username, password);
        logger.info("账号 {} 注册成功，时间: {}", username, new Timestamp(new Date().getTime()));
    }

    @Override
    public void deleteManager(Long managerId) {
        managerMapper.deleteRole(managerId);
        managerMapper.deleteManager(managerId);

    }

    @Override
    public ManagerInfoVO[] getManagers() {

        return managerMapper.getManagers()
                .stream()
                .filter(o -> !managerMapper.getAdminIds().contains(o.getId()))
                .map(o -> {
                    ManagerInfoVO vo = new ManagerInfoVO();
                    vo.setManagerId(o.getId());
                    vo.setUsername(o.getUsername());
                    vo.setPassword(o.getPassword());
                    return vo;
                }).toArray(ManagerInfoVO[]::new);
    }

    /**
     * 向数据库中加入一条管理员的账户记录
     *
     * @param username 用户另
     * @param password 密码
     */
    @Transactional
    void addNewManager(String username, String password) {
        User user = User.generateNerUser(username, password);
        managerMapper.addNewManager(user);
        managerMapper.addRole(user.getId());
    }
}
