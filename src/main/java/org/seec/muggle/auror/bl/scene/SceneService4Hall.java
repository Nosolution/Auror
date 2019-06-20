package org.seec.muggle.auror.bl.scene;

/**
 * @Description 判断该影厅是否有未完成排片
 * @Author 233loser
 * @Date 2019/6/20 22:20
 * @Version 1.0
 **/
public interface SceneService4Hall {
    boolean isOccupied(Long hallId);
}
