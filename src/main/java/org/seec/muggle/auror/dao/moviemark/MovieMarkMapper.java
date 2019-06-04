package org.seec.muggle.auror.dao.moviemark;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:45
 * @Version 1.0
 **/
@DaoMapper
public interface MovieMarkMapper {

    int insertMark(@Param("userId")Long userId,@Param("movieId")Long movieId);
}
