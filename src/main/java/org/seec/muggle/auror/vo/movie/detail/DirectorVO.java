package org.seec.muggle.auror.vo.movie.detail;

public class DirectorVO
{
    String name;
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

    public DirectorVO(){

    }
    public DirectorVO(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
