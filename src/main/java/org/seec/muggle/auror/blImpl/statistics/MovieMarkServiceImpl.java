package org.seec.muggle.auror.blImpl.statistics;

import org.seec.muggle.auror.bl.deal.OrderService4Mark;
import org.seec.muggle.auror.bl.movie.MovieService4Mark;
import org.seec.muggle.auror.bl.scene.SceneService4Mark;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.dao.moviemark.MovieMarkMapper;
import org.seec.muggle.auror.po.FavorRecordPO;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MovieMarkServiceImpl implements MovieMarkService {


    @Autowired
    MovieMarkMapper movieMarkMapper;

    @Autowired
    MovieService4Mark movieService4Mark;

    @Autowired
    SceneService4Mark sceneService4Mark;

    @Autowired
    OrderService4Mark orderService4Mark;

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
        if(movieMarkMapper.findFavorByMovieIdAndUserId(movieId,userId) !=null){
            vo.setMsg("重复标记");
            return vo;
        }
        movieMarkMapper.insertMark(userId,movieId, new Date());
        vo.setSucc(true);
        return vo;
    }


    /**
     * @Author jyh
     * @Description //第一次尝试用stream的Compare
     * @Date 14:37 2019/6/6
     * @Param [movieId]
     * @return org.seec.muggle.auror.vo.movie.statistics.FavorNumVO[]
     **/
    @Override
    public FavorNumVO[] getFavorsByDate(Long movieId){
        List<FavorRecordPO> favors = movieMarkMapper.findFavorByMovieId(movieId);
        Date minDate = favors.stream().min(Comparator.comparing(FavorRecordPO::getTime)).get().getTime();
        Date maxDate = favors.stream().max(Comparator.comparing(FavorRecordPO::getTime)).get().getTime();
        List<Date> dates = Stream.iterate(minDate, date ->ForwardDate(date) )
                .limit((long) ((ForwardDate(maxDate).getTime() - minDate.getTime()) / 1000 / 60 / 60 / 24)).collect(Collectors.toList());
        FavorNumVO[] vos = new FavorNumVO[dates.size()];
        for(int i = 0;i<vos.length;i++){
            FavorNumVO current = new FavorNumVO();
            current.setDate(dates.get(i));
            current.setFavorNums(0);
            vos[i] = current;
        }
        favors.forEach(o -> {
            int pos = dates.indexOf(o.getTime());
            FavorNumVO current = vos[pos];
            current.setFavorNums(current.getFavorNums()+1);
            vos[pos] = current;
        });
        return vos;
    }

    private Date ForwardDate(Date current){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(current);
        rightNow.add(Calendar.DATE,1);
        return rightNow.getTime();
    }

    @Override
    public MovieMarkVO[] getFavorsByUserId(Long userId) {
        List<Long> movies = movieMarkMapper.selectMovieIdByUserId(userId);
        if(movies.size()==0) {
            return new MovieMarkVO[0];
        }
        else {
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
                vo.setPosterUrl(po.getPosterUrl());
                if(po.getStatus()!=3){
                    if(po.getStartDate().before(new Date())){
                        po.setStatus(2);
                    }
                    else{
                        po.setStatus(1);
                    }
                    vo.setMovieStatus(po.getStatus());
                }
                List<ScenePO> scenes = sceneService4Mark.getScenesById(po.getId());
                if(orderService4Mark.hasSeen(userId,scenes)==1){
                    vo.setUserStatus(1);
                }
                else{
                    vo.setUserStatus(2);
                }
                vos.add(vo);
            });
            return vos.toArray(new MovieMarkVO[vos.size()]);
        }
    }
}
