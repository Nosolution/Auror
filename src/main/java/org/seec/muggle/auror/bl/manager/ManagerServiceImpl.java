package org.seec.muggle.auror.bl.manager;

import org.seec.muggle.auror.dao.account.RoleMapper;
import org.seec.muggle.auror.dao.account.UserMapper;
import org.seec.muggle.auror.dao.account.UserRoleMapper;
import org.seec.muggle.auror.dao.manager.ManagerMapper;
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
        insertNewMANAGER(username, password);
        logger.info("账号 {} 注册成功，时间: {}", username, new Timestamp(new Date().getTime()));
    }

    @Override
    public void deleteManager(Long managerId) {
        managerMapper.deleteRole(managerId);
        managerMapper.deleteManager(managerId);
//        userRoleMapper.deleteByUserId(manageId);
//        userMapper.deleteUserById(manageId);
    }

    @Override
    public ManagerInfoVO[] getManagers() {
//        List<Long> managerIds = userRoleMapper.getAllManagerId();
//        List<ManagerInfoVO> vos = new ArrayList<>();
//        managerIds.forEach(o -> {
//            User user = userMapper.getUserById(o);
//            ManagerInfoVO vo = new ManagerInfoVO();
//            vo.setManageId(o);
//            vo.setUsername(user.getUsername());
//            vo.setPassword(user.getPassword());
//            vos.add(vo);
//        });
//        return vos.toArray(new ManagerInfoVO[vos.size()]);
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

    @Transactional
    void insertNewMANAGER(String username, String password) {
        User user = User.generateNerUser(username, password);
        managerMapper.addNewManager(user);
//        userMapper.insert(user);
//        user被保存后会产生id
//        Role manager = roleMapper.getRoleByName(RoleEnum.MOVIE_MANAGER.name().toLowerCase());
        managerMapper.addRole(user.getId());
//        userRoleMapper.insert(new UserRole(user.getId(), manager.getId()));

    }
}
