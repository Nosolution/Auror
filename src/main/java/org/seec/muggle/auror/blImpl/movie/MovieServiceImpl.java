package org.seec.muggle.auror.blImpl.movie;

import org.seec.muggle.auror.bl.movie.MovieService;
import org.seec.muggle.auror.bl.movie.MovieService4Scene;
import org.seec.muggle.auror.dao.movie.MovieMapper;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnshelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/1 21:36
 * @Version 1.0
 **/
@Service
public class MovieServiceImpl implements MovieService , MovieService4Scene {
    @Autowired
    MovieMapper movieMapper;

    /**
     * @Author jyh
     * @Description TODO //有点小问题，如果没有可见的应该传啥
     * @Date 18:41 2019/6/4
     * @Param []
     * @return org.seec.muggle.auror.vo.movie.onshelf.MovieOnshelfVO[]
     **/
    @Override
    public MovieOnshelfVO[] getMovieOnshelf() {
        Date date = new Date();
        List<MoviePO> moviesOnshelf = movieMapper.getMovieOnshelf(date);
        MovieOnshelfVO[] vos = new MovieOnshelfVO[moviesOnshelf.size()];
        for(int i = 0; i<moviesOnshelf.size();i++){
            MoviePO po = moviesOnshelf.get(i);
            vos[i] = new MovieOnshelfVO(po,!date.before(po.getStartDate()));//判断当前时间是否>=电影上映开始时间
        }
        return vos;
    }

    @Override
    public MoviePopularVO[] getMoviePopular() {
        return new MoviePopularVO[0];
    }

    @Override
    public BasicVO addMovie(MovieAddForm form){
        MoviePO moviePO = new MoviePO(form);
        BasicVO vo = new BasicVO();
        if(false){
            vo.setSucc(false);
            vo.setMsg("已上架");
            return vo;
        }
        movieMapper.insertMovie(moviePO);
        for(int i = 0;i<form.getDirectors().length;i++){
            movieMapper.insertCast(form.getDirectors()[i].getUrl(),form.getDirectors()[i].getName());
            movieMapper.insertMovieCast(moviePO.getMovieName(),form.getDirectors()[i].getName(),"Director");
        }
        for(int i = 0;i<form.getStarrings().length;i++){
            movieMapper.insertCast(form.getStarrings()[i].getUrl(),form.getStarrings()[i].getName());
            movieMapper.insertMovieCast(moviePO.getMovieName(),form.getStarrings()[i].getName(),"Actor");
        }
        return  vo;
    }

    @Override
    public MovieDetailsVO getMovieDetail(Long id){
        MoviePO po =  movieMapper.findMovieById(id);

        if(po == null ){
            return new MovieDetailsVO();
        }
        Date date = new Date();
        if(date.before(po.getVisibleDate())){
            return new MovieDetailsVO(po,0);
        }
        else if(date.after(po.getEndDate())){
            return new MovieDetailsVO(po,2);
        }
        else{
            return new MovieDetailsVO(po,1);
        }
    }

    @Override
    public Integer getLengthById(Long movieId) {
        MoviePO po = movieMapper.findMovieById(movieId);
        return po.getLength();
    }
}
