package org.seec.muggle.auror.dao;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.FavorRecordPO;
import org.seec.muggle.auror.vo.DateLikeForm;

import java.util.List;


/**
 * Created by liying on 2019/3/23.
 */
@DaoMapper
public interface FavoriteRecordMapper extends BaseOperation<FavorRecordPO> {
//    /**
//     * 插入一条想看记录
//     *
//     * @vo movieId
//     * @vo userId
//     * @return
//     */
//    int insertOneLike(@Param("movieId") int movieId, @Param("userId") int userId);

    /**
     * 删除一条想看记录
     *
     * @param movieId
     * @param userId
     * @return
     */
    int delete(@Param("movieId") int movieId, @Param("userId") int userId);


    /**
     * 根据id查找想看的人数
     *
     * @param movieId
     * @return
     */
    int selectFavoriteNums(int movieId);

    /**
     * 根据movieId和userId查找记录
     *
     * @param movieId
     * @param userId
     * @return
     */
    int selectLikeMovie(@Param("movieId") int movieId, @Param("userId") int userId);

    /**
     * 获得某个电影的喜爱的人数按日期统计
     *
     * @param movieId
     * @return
     */
    List<DateLikeForm> getDateLikeNum(int movieId);
}
