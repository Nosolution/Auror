package org.seec.muggle.auror.blImpl.movie_statistics;

import org.seec.muggle.auror.bl.movie_statistics.MovieMarkService;
import org.seec.muggle.auror.dao.moviemark.MovieMarkMapper;
import org.seec.muggle.auror.vo.BasicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:42
 * @Version 1.0
 **/
@Service
public class MovieMarkServiceImpl implements MovieMarkService {

    @Autowired
    MovieMarkMapper movieMarkMapper;

    /**
     * @Author jyh
     * @Description //TODO 重复插入异常捕获
     * @Date 20:54 2019/6/4
     * @Param [userId, movieId]
     * @return org.seec.muggle.auror.vo.BasicVO
     **/
    @Override
    public BasicVO mark(Long userId, Long movieId) {
        BasicVO vo = new BasicVO();
        movieMarkMapper.insertMark(userId,movieId);
        vo.setSucc(true);
        return vo;
    }
}
