package org.seec.muggle.auror.po;

import lombok.Data;

/**
 * {@link Role}类和{@link Permission}类的中间联系实体
 *
 * @author Nosolution
 * @version 1.0
 * @see Role
 * @see Permission
 * @since 2019/4/6
 */
@Data
public class RolePermission {
    private Long roleId;
    private Long permissionId;
}
