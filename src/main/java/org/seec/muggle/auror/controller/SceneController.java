package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.scene.SceneService;
import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.Vary.SceneVaryForm;
import org.seec.muggle.auror.vo.scene.addition.SceneAdditionForm;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:00
 * @Version 1.0
 **/
@CrossOrigin
@RestController(value = "/api/scene")
public class SceneController {

    @Autowired
    SceneService sceneService;

    @GetMapping(value = "/info/of_movie?movieid={movieid}")
    public ResponseEntity<?> sceneInfoByMovie(@PathVariable Long movieId){
        return ResponseEntity.ok(new MovieSceneInfoVO());
    }

    @PostMapping(value = "/order/seat/selection")
    public ResponseEntity<?> seatSelection(@RequestBody SeatsSelectionForm form){
        boolean isSucc = false;
        if(isSucc){
            return ResponseEntity.ok(new SeatsSelectionVO());
        }
        else {
            return ResponseEntity.status(405).body("to do");
        }
    }

    @GetMapping(value = "/info/of_hall?hallId={hallId}&date={date}")
    public ResponseEntity<?> getSceneInfoByHallIdAndDate(@PathVariable Long hallId,@PathVariable String date){
        return ResponseEntity.ok(new InfoVO());
    }

    @PostMapping(value = "")
    public ResponseEntity addMovieScene(@RequestBody SceneAdditionForm form){
        sceneService.addScene(form.getMovieId(),form.getHallId(),form.getDate(),form.getStartTime(),form.getPrice());
        return ResponseEntity.ok("");
    }

    @PutMapping(value = "")
    public ResponseEntity varyMovieScene(@RequestBody SceneVaryForm form){
        return ResponseEntity.ok("");
    }
}
