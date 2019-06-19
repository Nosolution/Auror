package org.seec.muggle.auror.dao.hall;

import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.dao.BaseOperation;
import org.seec.muggle.auror.po.HallPO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:02
 * @Version 1.0
 **/
@DaoMapper
public interface HallMapper extends BaseOperation<HallPO> {
//    int insertNewHall(@Param("hallName")String name,@Param("seatCount")String seatCount);

//    HallPO getHallById(Long hallId);

    HallPO getHallByName(String hallName);

    List<HallPO> getAll();
}
