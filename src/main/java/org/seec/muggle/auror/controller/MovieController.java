package org.seec.muggle.auror.controller;


import org.seec.muggle.auror.bl.movie.MovieService;
import org.seec.muggle.auror.bl.statistics.MovieMarkService;
import org.seec.muggle.auror.bl.statistics.StatisticsService;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.comment.CommentForm;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.delete.MovieDelete;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.marking.MovieMarkForm;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnShelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.seec.muggle.auror.vo.movie.statistics.AttendenceVO;
import org.seec.muggle.auror.vo.movie.statistics.BoxOfficeVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author jyh
 * @date 2019-05-22
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    MovieService movieService;

    @Autowired
    MovieMarkService movieMarkService;

    @Autowired
    JwtUtil jwtUtil;
    @Value("${jwt.header}")
    String tokenHeader;

    @GetMapping(value = "/detail/{movieId}")
    public ResponseEntity<?> getMovieDetail(@PathVariable Long movieId) {
//        MovieDetailsVO movieDetail = new MovieDetailsVO(1l,"雷  神 Thor: Ragnarok","https://s2.ax1x.com/2019/05/07/EyJKv4.png","Action, Adventure, Drama",2019,123,8.9);
//        DirectorVO[] directors = new DirectorVO[2];
//        directors[0] = new DirectorVO("雷神","https://s2.ax1x.com/2019/05/07/EyJKv4.png");
//        directors[1] = new DirectorVO("李爹","https://s2.ax1x.com/2019/05/09/EgLvlj.png");
//        StarringVO[] starrings = new StarringVO[5];
//        starrings[0] = new StarringVO("国照","https://s2.ax1x.com/2019/05/09/EgOpmq.png");
//        starrings[1] = new StarringVO("姜神","https://s2.ax1x.com/2019/05/09/EgXzd0.png");
//        starrings[2] = new StarringVO("耿爷", "https://s2.ax1x.com/2019/05/09/EgjCJU.png");
//        starrings[3] = new StarringVO("羊男","https://s2.ax1x.com/2019/05/09/EgjAy9.png");
//        starrings[4] = new StarringVO("鹿女","https://s2.ax1x.com/2019/05/09/Egjedx.png");
//        movieDetail.setDirector(directors);
//        movieDetail.setStarring(starrings);
        MovieDetailsVO movieDetail = movieService.getMovieDetail(movieId);
        return ResponseEntity.ok(movieDetail);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<?> getPopularMovie() {
        MoviePopularVO[] vo = movieService.getMoviePopular();
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/onshelf")
    public ResponseEntity<?> getMovieOnShelf() {
        MovieOnShelfVO[] vos = movieService.getMovieOnShelf();
        return ResponseEntity.ok(vos);
    }

    @PostMapping(value = "/mark")
    public ResponseEntity<?> markMovie(@RequestBody MovieMarkForm form) {
        BasicVO vo = movieMarkService.mark(form.getUserId(), form.getMovieId());
        if (vo.isSucc()) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(405).body(vo.getMsg());
        }
    }

    @PostMapping(value = "/comment")
    public ResponseEntity<?> commentMovie(HttpServletRequest request,@RequestBody CommentForm form) {
        Long userId = getIdFromRequest(request);
        movieService.commentMovie(form.getMovieId(), form.getRate(), form.getComment(), userId);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/comment")
    public ResponseEntity<?> getMovieComment(@RequestParam("movieId") Long movieId) {
        List<CommentVO> comments = movieService.getMovieComment(movieId);
        CommentVO[] commentVOS = comments.toArray(new CommentVO[comments.size()]);
        return ResponseEntity.ok(commentVOS);
    }

    @PostMapping()
    public ResponseEntity<?> addMovie(@RequestBody MovieAddForm form) {
        movieService.addMovie(form);
        return ResponseEntity.ok(null);
    }

    @PutMapping()
    public ResponseEntity<?> varyMovie(@RequestBody MovieVaryForm form) {
        movieService.updateMovie(form);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteMovie(@RequestBody MovieDelete delete) {
        BasicVO vo = movieService.deleteMovie(delete.getMovieId());
        if (vo.isSucc()) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(405).body(vo.getMsg());
        }
    }

    @GetMapping(value = "/statistics/favor_num")
    public ResponseEntity<?> getFavorNum(@RequestParam("movieId") Long movieId) {
        return ResponseEntity.ok(movieMarkService.getFavorsByDate(movieId));
    }

    @GetMapping(value = "/statistic/attendance_rate")
    public ResponseEntity<?> getAttendance(@RequestParam("movieId") Long movieId) {
        AttendenceVO[] vo = statisticsService.getBoxOfficeRate(movieId);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/statistic/box_office")
    public ResponseEntity<?> getBoxOffice(@PathParam("movieId") Long movieId) {
        return ResponseEntity.ok(new BoxOfficeVO(statisticsService.getBoxOffice(movieId)));
    }

    @GetMapping(value = "/detail/batch")
    public ResponseEntity<?> getMoviesByList(@PathParam("movieIds") Long[] movieId) {
        MovieDetailsVO[] movies = new MovieDetailsVO[movieId.length];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = movieService.getMovieDetail(movieId[i]);
        }
        return ResponseEntity.ok(movies);
    }

    private Long getIdFromRequest(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        return jwtUtil.getIdFromToken(token);
    }
}
