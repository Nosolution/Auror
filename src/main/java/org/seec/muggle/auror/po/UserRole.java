package org.seec.muggle.auror.po;

import lombok.Data;
import lombok.NonNull;

/**
 * {@link User}和{@link Role}的中间联系实体
 *
 * @author Nosolution
 * @version 1.0
 * @see User
 * @see Role
 * @since 2019/4/6
 */
@Data
public class UserRole {
    @NonNull
    private Integer userId;
    @NonNull
    private Integer roleId;
}
