package org.seec.muggle.auror.param;

public class StarringVO {
    /**
     * 姓名
     */
    String  name;
    /**
     * 图片
     */
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public StarringVO(){

    }

    public StarringVO(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
