package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 19:43
 * @Version 1.0
 **/
public class UserBasic {
    String username;
    String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserBasic(String username, String url) {
        this.username = username;
        this.url = url;
    }
    public UserBasic(){

    }
}
