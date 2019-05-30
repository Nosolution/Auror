package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.hall.all.SingleHallVO;
import org.seec.muggle.auror.vo.hall.single.SingleHallForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:06
 * @Version 1.0
 **/
@CrossOrigin
@RestController(value = "/api/hall")
public class HallController {
    @PostMapping()
    public ResponseEntity<?> addHall(@RequestBody SingleHallForm form){
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllHall(){
        return ResponseEntity.ok(new SingleHallVO[]{});
    }
}
