package org.seec.muggle.auror.po;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/7 16:58
 * @Version 1.0
 **/
public class MemberPO {
    Long id;
    Long strategyId;
    Long userId;
    Integer threshold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public MemberPO() {

    }
}
