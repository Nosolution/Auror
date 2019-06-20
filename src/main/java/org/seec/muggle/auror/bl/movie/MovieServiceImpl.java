package org.seec.muggle.auror.bl.movie;

import org.seec.muggle.auror.dao.movie.MovieMapper;
import org.seec.muggle.auror.entity.movie.Movie4Mark;
import org.seec.muggle.auror.entity.movie.Movie4Order;
import org.seec.muggle.auror.entity.movie.Movie4Scene;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.CastPO;
import org.seec.muggle.auror.po.CommentPO;
import org.seec.muggle.auror.po.MovieBoxOfficeMap;
import org.seec.muggle.auror.po.MoviePO;
import org.seec.muggle.auror.service.movie.MovieService;
import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnShelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/1 21:36
 * @Version 1.0
 **/
@Service
public class MovieServiceImpl implements MovieService, MovieService4Scene, MovieService4Mark, MovieService4Order {


    @Autowired
    MovieMapper movieMapper;

    @Autowired
    AccountService4Movie accountService4Movie;

    @Autowired
    SceneService4Movie sceneService4Movie;

    @Autowired
    StatisticsService4Movie statisticsService4Movie;

    /**
     * @return org.seec.muggle.auror.vo.movie.onshelf.MovieOnShelfVO[]
     * @Author jyh
     * @Description TODO //有点小问题，如果没有可见的应该传啥
     * @Date 18:41 2019/6/4
     * @Param []
     **/
    @Override
    public MovieOnShelfVO[] getMovieOnShelf() {
        List<MoviePO> moviesOnShelf = movieMapper.getMovieOnShelf();
        MovieOnShelfVO[] vos = new MovieOnShelfVO[moviesOnShelf.size()];
        for (int i = 0; i < moviesOnShelf.size(); i++) {
            MoviePO po = moviesOnShelf.get(i);
            vos[i] = new MovieOnShelfVO(po, po.getStatus() == 2);//判断当前时间是否>=电影上映开始时间
        }
        return vos;
    }

    @Override
    public MoviePopularVO[] getMoviePopular() {
        List<MoviePO> movies = movieMapper.getMovieOnShelf();
        List<MovieBoxOfficeMap> maps = new ArrayList<>();
        movies.forEach(o -> {
            MovieBoxOfficeMap map = new MovieBoxOfficeMap();
            map.setBoxOffice(statisticsService4Movie.getBoxOffice(o.getId()));
            map.setMovieId(o.getId());
            maps.add(map);
        });
        maps.sort(Comparator.comparing(MovieBoxOfficeMap::getBoxOffice));
        List<MoviePopularVO> vos = new ArrayList<>();
        for (int i = maps.size() - 1; i >= 0; i--) {
            MoviePopularVO vo = new MoviePopularVO();
            vo.setMovieId(maps.get(i).getMovieId());
            MoviePO moviePO = movieMapper.get(maps.get(i).getMovieId());
            vo.setMovieDescription(moviePO.getDescription());
            vo.setMovieLength(moviePO.getLength());
            vo.setMovieName(moviePO.getMovieName());
            vo.setMovieYear(moviePO.getMovieYear());
            vo.setMovieType(moviePO.getMovieType());
            vo.setPosterUrl(moviePO.getPosterUrl());
            vos.add(vo);
            if (vos.size() == 7) {
                break;
            }
        }
        return vos.toArray(new MoviePopularVO[vos.size()]);
    }

    @Override
    public void addMovie(MovieAddForm form) {
        MoviePO moviePO = new MoviePO(form);
        movieMapper.insert(moviePO);
        for (int i = 0; i < form.getDirectors().length; i++) {
            CastPO castPO = movieMapper.getCastByName(form.getDirectors()[i].getName());
            //变相初始化，如果返回Null则注入一个新的cast
            if (castPO == null) {
                castPO = new CastPO();
                castPO.setCastName(form.getDirectors()[i].getName());
                castPO.setUrl(form.getDirectors()[i].getUrl());
                movieMapper.insertCast(castPO);
            }
            movieMapper.insertMovieCast(moviePO.getId(), castPO.getId(), "Director");
        }
        for (int i = 0; i < form.getStarrings().length; i++) {
            CastPO castPO = movieMapper.getCastByName(form.getStarrings()[i].getName());
            //变相初始化，如果返回Null则注入一个新的cast
            if (castPO == null) {
                castPO = new CastPO();
                castPO.setCastName(form.getStarrings()[i].getName());
                castPO.setUrl(form.getStarrings()[i].getUrl());
                movieMapper.insertCast(castPO);
            }
            movieMapper.insertMovieCast(moviePO.getId(), castPO.getId(), "Actor");
        }
    }

    @Override
    public MovieDetailsVO getMovieDetail(Long movieId) {
        MoviePO po = movieMapper.get(movieId);
        if (po == null) {
            return new MovieDetailsVO();
        }
        //每次获取电影详情时判断是否已经上映了
        if (po.getStartDate().before(new Date()) && po.getStatus() == 1) {
            po.setStatus(2);
            movieMapper.updateMovieState(2, po.getId());
        }
        Optional<Integer> scores = Optional.ofNullable(movieMapper.sumScore(movieId));
        Integer totalScore = scores.orElse(0);
        Optional<Integer> num = Optional.ofNullable(movieMapper.sumCommentNum(movieId));
        Integer scoreNum = num.orElse(0);
        double averageScore = (double) scoreNum == 0 ? 0.0 : totalScore / scoreNum;
        return new MovieDetailsVO(po, po.getStatus(), averageScore);

    }

    @Override
    public Integer getLengthById(Long movieId) {
        MoviePO po = movieMapper.get(movieId);
        return po.getLength();
    }

    @Override
    public List<CommentVO> getMovieComment(Long movieId) {
        List<CommentPO> commentPOS = movieMapper.getCommentsByMovieId(movieId);
        List<CommentVO> vos = new ArrayList<>();
        commentPOS.stream()
                .sorted(Comparator.comparing(CommentPO::getCommentTime).reversed())
                .forEach(o -> {
                    String username = accountService4Movie.getUsernameById(o.getUserId());
                    vos.add(new CommentVO(o, username));
                });
        return vos;
    }

    @Override
    public void updateMovie(MovieVaryForm form) {
        MoviePO po = new MoviePO(form);
        movieMapper.update(po);
        movieMapper.deleteMovieCastByMovieId(form.getMovieId());

        for (int i = 0; i < form.getDirectors().length; i++) {
            CastPO castPO = movieMapper.getCastByName(form.getDirectors()[i].getName());
            //变相初始化，如果返回Null则注入一个新的cast
            if (castPO == null) {
                castPO = new CastPO();
                castPO.setCastName(form.getDirectors()[i].getName());
                castPO.setUrl(form.getDirectors()[i].getUrl());
                movieMapper.insertCast(castPO);
            }
            movieMapper.insertMovieCast(form.getMovieId(), castPO.getId(), "Director");
        }
        for (int i = 0; i < form.getStarrings().length; i++) {
            CastPO castPO = movieMapper.getCastByName(form.getStarrings()[i].getName());
            //变相初始化，如果返回Null则注入一个新的cast
            if (castPO == null) {
                castPO = new CastPO();
                castPO.setCastName(form.getStarrings()[i].getName());
                castPO.setUrl(form.getStarrings()[i].getUrl());
                movieMapper.insertCast(castPO);
            }


            movieMapper.insertMovieCast(form.getMovieId(), castPO.getId(), "Actor");
        }
    }


    @Override
    public void deleteMovie(Long movieId) {
        List<Timestamp> times = sceneService4Movie.getSceneEndsByMovieId(movieId);
        Collections.sort(times);

        if (times.size() == 0 || times.get(times.size() - 1).before(Timestamp.valueOf(LocalDateTime.now()))) {
            movieMapper.delete(movieId);
        } else {
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "该影片已排片，暂不能删除,最早可删除时间为：" + (times.get(times.size() - 1)));
        }
    }

    @Override
    public void commentMovie(Long movieId, Long userId, Integer score, String comment) {
        movieMapper.insertComment(movieId, userId, score, comment, Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public Movie4Mark getMovieInfoByIdForMark(Long movieId) {
        Movie4Mark res = new Movie4Mark();
        MoviePO po = movieMapper.get(movieId);
        res.setId(po.getId());
        res.setMovieName(po.getMovieName());
        res.setDescription(po.getDescription());
        res.setLength(po.getLength());
        res.setMovieYear(po.getMovieYear());
        res.setPosterUrl(po.getPosterUrl());
        res.setMovieType(po.getMovieType());
        res.setStatus(po.getStatus());
        return res;
    }

    @Override
    public String getMovieNameById(Long movieId) {
        return movieMapper.get(movieId).getMovieName();
    }

    @Override
    public Movie4Order getMovieInfoByIdForOrder(Long movieId) {
        MoviePO po = movieMapper.get(movieId);
        Movie4Order res = new Movie4Order();
        res.setMovieName(po.getMovieName());
        res.setPosterUrl(po.getPosterUrl());
        return res;
    }

    @Override
    public Movie4Scene getMovieInfoByIdForScene(Long movieId) {
        MoviePO po = movieMapper.get(movieId);
        Movie4Scene res = new Movie4Scene();
        res.setMovieName(po.getMovieName());
        res.setPosterUrl(po.getPosterUrl());
        res.setLength(po.getLength());
        res.setStatus(po.getStatus());
        return res;
    }

}
