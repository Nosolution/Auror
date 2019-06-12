package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.hall.HallService;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.hall.all.SingleHallVO;
import org.seec.muggle.auror.vo.hall.single.SingleHallForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:06
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api/hall")
public class HallController {
    @Autowired
    HallService hallService;

    @PostMapping()
    public ResponseEntity<?> addHall(@RequestBody SingleHallForm form) {
        BasicVO vo = hallService.addHall(form.getHallName(), form.getSeats());
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllHall() {
        SingleHallVO[] halls = hallService.getHalls();
        return ResponseEntity.ok(halls);
    }
}
