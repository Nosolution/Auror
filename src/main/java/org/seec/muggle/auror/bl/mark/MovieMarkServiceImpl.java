package org.seec.muggle.auror.bl.mark;

import org.seec.muggle.auror.bl.movie.MovieService4Mark;
import org.seec.muggle.auror.bl.order.OrderService4Mark;
import org.seec.muggle.auror.bl.scene.SceneService4Mark;
import org.seec.muggle.auror.dao.moviemark.MovieMarkMapper;
import org.seec.muggle.auror.entity.movie.Movie4Mark;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.MovieMarkPO;
import org.seec.muggle.auror.service.mark.MovieMarkService;
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
        List<MovieMarkPO> exactFavors = movieMarkMapper.getFavorByMovieId(movieId);
        if (exactFavors.size() == 0)
            return new FavorNumVO[0];
        //库里的数据精度过高导致下标获取异常，这边统一做一次数据粗化
        List<MovieMarkPO> favors = new ArrayList<>();
        for (int i = 0; i < exactFavors.size(); i++) {
            MovieMarkPO movieMarkPO = exactFavors.get(i);
            String currentDate = DateUtil.dateToString(movieMarkPO.getTime());
            movieMarkPO.setTime(DateUtil.stringToDate(currentDate));
            favors.add(movieMarkPO);
        }


        Date minDate = favors.stream().min(Comparator.comparing(MovieMarkPO::getTime)).get().getTime();
        Date maxDate = favors.stream().max(Comparator.comparing(MovieMarkPO::getTime)).get().getTime();
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
                Movie4Mark movieInfo = movieService4Mark.getMovieInfoByIdForMark(o);
                vo.setMovieYear(movieInfo.getMovieYear());
                vo.setMovieDescription(movieInfo.getDescription());
                vo.setMovieId(movieInfo.getId());
                vo.setMovieLength(movieInfo.getLength());
                vo.setMovieType(movieInfo.getMovieType());
                vo.setMovieName(movieInfo.getMovieName());
                vo.setMovieStatus(movieInfo.getStatus());
                vo.setPosterUrl(movieInfo.getPosterUrl());

                List<Long> sceneIds = sceneService4Mark.getSceneIdsByMovieId(movieInfo.getId());
                if (orderService4Mark.hasSeen(userId, sceneIds)) {
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
