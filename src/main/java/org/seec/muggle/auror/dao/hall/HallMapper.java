package org.seec.muggle.auror.dao.hall;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:02
 * @Version 1.0
 **/
@DaoMapper
public interface HallMapper {
    int insertNewHall(@Param("name")String name,@Param("seats")String seats);
}
