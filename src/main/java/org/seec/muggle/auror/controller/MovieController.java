package org.seec.muggle.auror.controller;


import org.seec.muggle.auror.bl.MovieService;
import org.seec.muggle.auror.vo.movie.detail.DirectorVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.detail.StarringVO;
import org.seec.muggle.auror.vo.movie.marking.MovieMarkForm;
import org.seec.muggle.auror.vo.movie.onshelf.MovieOnshelfVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jyh
 * @date 2019-05-22
 */
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/detail/{movieId}")
    public ResponseEntity<?> getMovieDetail(@PathVariable Integer movieId){
        MovieDetailsVO movieDetail = new MovieDetailsVO(1l,"雷  神 Thor: Ragnarok","https://s2.ax1x.com/2019/05/07/EyJKv4.png","Action, Adventure, Drama",2019,123,8.9);
        DirectorVO[] directors = new DirectorVO[2];
        directors[0] = new DirectorVO("雷神","https://s2.ax1x.com/2019/05/07/EyJKv4.png");
        directors[1] = new DirectorVO("李爹","https://s2.ax1x.com/2019/05/09/EgLvlj.png");
        StarringVO[] starrings = new StarringVO[5];
        starrings[0] = new StarringVO("国照","https://s2.ax1x.com/2019/05/09/EgOpmq.png");
        starrings[1] = new StarringVO("姜神","https://s2.ax1x.com/2019/05/09/EgXzd0.png");
        starrings[2] = new StarringVO("耿爷", "https://s2.ax1x.com/2019/05/09/EgjCJU.png");
        starrings[3] = new StarringVO("羊男","https://s2.ax1x.com/2019/05/09/EgjAy9.png");
        starrings[4] = new StarringVO("鹿女","https://s2.ax1x.com/2019/05/09/Egjedx.png");
        movieDetail.setDirector(directors);
        movieDetail.setStarring(starrings);
    return ResponseEntity.ok(movieDetail);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<?> getPopularMovie(){
        return ResponseEntity.ok(new MoviePopularVO[]{});
    }

    @GetMapping(value = "/onshelf")
    public ResponseEntity<?> getMovieOnShelf(){
        return ResponseEntity.ok(new MovieOnshelfVO[]{});
    }

    @PostMapping(value = "/mark")
    public ResponseEntity<?> markMovie(@RequestBody MovieMarkForm form){
        if(true){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.status(405).body("请稍后");
        }
    }


}
