package org.seec.muggle.auror.controller;


import org.seec.muggle.auror.bl.MovieService;
import org.seec.muggle.auror.dao.Movie;
import org.seec.muggle.auror.param.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * @author fjj
 * @date 2019/3/12 6:17 PM
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMovie(@RequestBody MovieForm addMovieForm){
        if(movieService.addMovie(addMovieForm)){
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(movieService.addMovie(addMovieForm));
    }

    @RequestMapping(value = "/movie/{id}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> searchOneMovieByIdAndUserId(@PathVariable int id, @PathVariable int userId){
        return ResponseEntity.ok(movieService.searchOneMovieByIdAndUserId(id, userId));
    }

    @RequestMapping(value = "/movie/all", method = RequestMethod.GET)
    public ResponseEntity<?> searchAllMovie(){
        return ResponseEntity.ok(movieService.searchAllMovie());
    }

    @RequestMapping(value = "/movie/{movieId}/like", method = RequestMethod.POST)
    public ResponseEntity<?> likeMovie(@PathVariable int movieId,@RequestParam int userId){
        String res = movieService.likeMovie(movieId,userId);
        if(res.equals("Success")){
            return ResponseEntity.ok("Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
        }
    }
    @RequestMapping(value = "/movie/{movieId}/unlike", method = RequestMethod.POST)
    public ResponseEntity<?> unlikeMovie(@PathVariable int movieId, @RequestParam int userId){
        String res = movieService.unLikeMovie(userId,movieId);
        if(res.equals("Success")){
            return ResponseEntity.ok("Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
        }
    }
    @RequestMapping(value = "/movie/{movieId}/like/count", method = RequestMethod.GET)
    public ResponseEntity getMovieLikeCounts(@PathVariable int movieId){
        return ResponseEntity.ok(movieService.getCountOfLikes(movieId));
    }
    @RequestMapping(value = "/movie/{movieId}/like/date", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieLikeCountByDate(@PathVariable int movieId){
        return ResponseEntity.ok(movieService.getLikeNumsGroupByDate(movieId));
    }

    @RequestMapping(value = "/movie/search",method = RequestMethod.GET)
    public ResponseEntity<?> getMovieByKeyword(@RequestParam String keyword){
        return ResponseEntity.ok(movieService.getMovieByKeyword(keyword));
    }
}
