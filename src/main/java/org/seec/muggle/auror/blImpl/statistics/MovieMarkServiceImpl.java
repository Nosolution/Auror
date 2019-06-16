package org.seec.muggle.auror.blImpl.statistics;

import org.seec.muggle.auror.bl.deal.OrderService4Mark;
import org.seec.muggle.auror.bl.movie.MovieService4Mark;
import org.seec.muggle.auror.bl.scene.SceneService4Mark;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.bl.statistics.MovieMarkService4Message;
import org.seec.muggle.auror.dao.moviemark.MovieMarkMapper;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.FavorRecordPO;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 20:42
 * @Version 1.0
 **/
@Service
public class MovieMarkServiceImpl implements MovieMarkService, MovieMarkService4Message {


    @Autowired
    MovieMarkMapper movieMarkMapper;

    @Autowired
    MovieService4Mark movieService4Mark;

    @Autowired
    SceneService4Mark sceneService4Mark;

    @Autowired
    OrderService4Mark orderService4Mark;

    /**
     * @return org.seec.muggle.auror.vo.BasicVO
     * @Author jyh
     * @Description //TODO 重复插入异常捕获
     * @Date 20:54 2019/6/4
     * @Param [userId, movieId]
     **/
    @Override
    public void mark(Long userId, Long movieId) {
        if (movieMarkMapper.getFavorByMovieIdAndUserId(movieId, userId) != null)
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "重复标记");
        movieMarkMapper.insertMark(userId, movieId, new Date());

    }


    /**
     * @return org.seec.muggle.auror.vo.movie.statistics.FavorNumVO[]
     * @Author jyh
     * @Description //第一次尝试用stream的Compare
     * //修改 删除无效的0记录
     * @Date 14:37 2019/6/6
     * @Param [movieId]
     **/
    @Override
    public FavorNumVO[] getFavorsByDate(Long movieId) {
        List<FavorRecordPO> favors = movieMarkMapper.getFavorByMovieId(movieId);
        if (favors.size() == 0)
            return new FavorNumVO[0];

        Date minDate = favors.stream().min(Comparator.comparing(FavorRecordPO::getTime)).get().getTime();
        Date maxDate = favors.stream().max(Comparator.comparing(FavorRecordPO::getTime)).get().getTime();
        List<Date> dates = Stream.iterate(minDate, date -> ForwardDate(date))
                .limit((long) ((ForwardDate(maxDate).getTime() - minDate.getTime()) / 1000 / 60 / 60 / 24)).collect(Collectors.toList());
        List<FavorNumVO> vos = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            FavorNumVO current = new FavorNumVO();
            String dayFormat = DateUtil.dateToString(dates.get(i));
            current.setDate(dayFormat);
            current.setFavorNums(0);
            vos.add(current);
        }
        favors.forEach(o -> {
            int pos = dates.indexOf(o.getTime());
            FavorNumVO current = vos.get(pos);
            current.setFavorNums(current.getFavorNums() + 1);
            vos.set(pos, current);
        });
        //过滤掉数值为0的日期。这是我再次修改的理由
        List<FavorNumVO> res = vos.stream().filter(o ->
                !o.getFavorNums().equals(0)
        ).collect(Collectors.toList());
        return res.toArray(new FavorNumVO[res.size()]);
    }

    private Date ForwardDate(Date current) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(current);
        rightNow.add(Calendar.DATE, 1);
        return rightNow.getTime();
    }


    @Override
    public List<Long> getUsersByMovieId(Long movieId) {
        return movieMarkMapper.getUserIdsByMovieId(movieId);
    }

    @Override
    public MovieMarkVO[] getFavorsByUserId(Long userId) {
        List<Long> movies = movieMarkMapper.getMovieIdByUserId(userId);
        if (movies.size() == 0) {
            return new MovieMarkVO[0];
        } else {
            List<MovieMarkVO> vos = new ArrayList<>();
            movies.forEach(o -> {
                MovieMarkVO vo = new MovieMarkVO();
                MoviePO po = movieService4Mark.getMovieById(o);
                vo.setMovieYear(po.getMovieYear());
                vo.setMovieDescription(po.getDescription());
                vo.setMovieId(po.getId());
                vo.setMovieLength(po.getLength());
                vo.setMovieType(po.getMovieType());
                vo.setMovieName(po.getMovieName());
                vo.setMovieStatus(po.getStatus());
                vo.setPosterUrl(po.getPosterUrl());

                List<ScenePO> scenes = sceneService4Mark.getScenesById(po.getId());
                if (orderService4Mark.hasSeen(userId, scenes) == 1) {
                    vo.setUserStatus(1);
                } else {
                    vo.setUserStatus(2);
                }
                vos.add(vo);
            });
            return vos.toArray(new MovieMarkVO[vos.size()]);
        }
    }
}
