package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 20:19
 * @Version 1.0
 **/
public class CastPO {
    Long id;
    String castName;
    String url;

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CastPO(){

    }
}
