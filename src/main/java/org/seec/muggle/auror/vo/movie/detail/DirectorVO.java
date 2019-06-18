package org.seec.muggle.auror.vo.movie.detail;

import lombok.Data;

@Data
public class DirectorVO {
    String name;
    String url;


    public DirectorVO() {

    }

    public DirectorVO(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
