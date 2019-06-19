package org.seec.muggle.auror.entity.account;

import lombok.Data;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 19:43
 * @Version 1.0
 **/
@Data
public class UserBasic {
    String username;
    String url;

    public UserBasic(String username, String url) {
        this.username = username;
        this.url = url;
    }

    public UserBasic() {

    }
}
