package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:00
 * @Version 1.0
 **/
@RestController(value = "/scene")
public class SceneController {

    @GetMapping(value = "/info/of_movie?movieid={movieid}")
    public ResponseEntity<?> sceneInfoByMovie(@PathVariable Integer movieId){
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
}
