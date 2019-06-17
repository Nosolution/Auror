package org.seec.muggle.auror.bl.order;

/**
 * @Description 数据服务接口
 * @Author jyh
 * @Date 2019/6/6 20:10
 * @Version 1.0
 **/
public interface OrderService4Statistics {
    /**
     * @Author jyh
     * @Description //获取已完成的订单，为计算上座率
     * @Date 22:21 2019/6/6
     * @Param [sceneId]
     * @return int
     **/
    int getNumsBySceneId(Long sceneId);

    /**
     * @Author jyh
     * @Description //获取某部电影的累计票房
     * @Date 23:10 2019/6/6
     * @Param [movieId]
     * @return java.lang.Integer
     **/
    Integer getBoxOffice(Long movieId);

}
