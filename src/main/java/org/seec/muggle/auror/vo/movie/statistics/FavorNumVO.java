package org.seec.muggle.auror.vo.movie.statistics;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:00
 * @Version 1.0
 **/
public class FavorNumVO {
    Integer favorNums;
    Date date;

    public Integer getFavorNums() {
        return favorNums;
    }

    public void setFavorNums(Integer favorNums) {
        this.favorNums = favorNums;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
