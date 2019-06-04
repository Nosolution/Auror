package org.seec.muggle.auror.controller;


import org.seec.muggle.auror.bl.movie.MovieService;
import org.seec.muggle.auror.bl.movie_statistics.MovieMarkService;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.movie.addition.MovieAddForm;
import org.seec.muggle.auror.vo.movie.comment.CommentForm;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.marking.MovieMarkForm;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnshelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.seec.muggle.auror.vo.movie.statistics.AttendenceVO;
import org.seec.muggle.auror.vo.movie.statistics.BoxOfficeVO;
import org.seec.muggle.auror.vo.movie.statistics.FavorNumVO;
import org.seec.muggle.auror.vo.movie.vary.MovieVaryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jyh
 * @date 2019-05-22
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieMarkService movieMarkService;

    @GetMapping(value = "/detail/{movieId}")
    public ResponseEntity<?> getMovieDetail(@PathVariable Long movieId){
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
    public ResponseEntity<?> getPopularMovie(){
        return ResponseEntity.ok(new MoviePopularVO[]{});
    }

    @GetMapping(value = "/onshelf")
    public ResponseEntity<?> getMovieOnShelf(){
        MovieOnshelfVO[] vos = movieService.getMovieOnshelf();
        return ResponseEntity.ok(vos);
    }

    @PostMapping(value = "/mark")
    public ResponseEntity<?> markMovie(@RequestBody MovieMarkForm form){
        BasicVO vo = movieMarkService.mark(form.getUserId(),form.getMovieId());
        if(vo.isSucc()){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.status(405).body(vo.getMsg());
        }
    }

    @PostMapping(value = "/comment")
    public ResponseEntity<?> getMovieComment(@RequestBody CommentForm form){
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/comment?movieId={movieId}")
    public ResponseEntity<?> getMovieComment(){
        return ResponseEntity.ok(new CommentVO[]{});
    }

    @PostMapping()
    public ResponseEntity<?> addMovie(@RequestBody MovieAddForm form){
        movieService.addMovie(form);
        return ResponseEntity.ok("");
    }

    @PutMapping()
    public ResponseEntity<?> varyMovie(@RequestBody MovieVaryForm form){
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/statistics/favor_num?movieId={movieId}")
    public ResponseEntity<?> getFavorNum(@PathVariable Integer movieId){
        return ResponseEntity.ok(new FavorNumVO[]{});
    }

    @GetMapping(value = "/statistic/attendance_rate?movieId={movieId}")
    public ResponseEntity<?> getAttandence(@PathVariable Integer movieId){
        return ResponseEntity.ok(new AttendenceVO[]{});
    }

    @GetMapping(value = "/statistic/box_office?movieId={movieId}")
    public ResponseEntity<?> getBoxOffice(@PathVariable Integer movieId){
        return ResponseEntity.ok(new BoxOfficeVO());
    }
}
