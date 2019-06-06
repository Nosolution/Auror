package org.seec.muggle.auror.blImpl.movie_statistics;

import org.hibernate.validator.cfg.defs.MaxDef;
import org.seec.muggle.auror.bl.movie_statistics.MovieMarkService;
import org.seec.muggle.auror.dao.moviemark.MovieMarkMapper;
import org.seec.muggle.auror.po.FavorRecordPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

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
        favors.stream().forEach(o->{
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
}
