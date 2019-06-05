package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 18:29
 * @Version 1.0
 **/
public class MemberStrategyPO {
    Long id;
    String name;
    String url;
    Integer threshold;
    Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public MemberStrategyPO(){

    }

    public MemberStrategyPO(String name, String url, Integer threshold, Double rate) {
        this.name = name;
        this.url = url;
        this.threshold = threshold;
        this.rate = rate;
    }
}
