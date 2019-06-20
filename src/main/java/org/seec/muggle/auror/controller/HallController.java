package org.seec.muggle.auror.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.seec.muggle.auror.service.hall.HallService;
import org.seec.muggle.auror.vo.hall.all.SingleHallVO;
import org.seec.muggle.auror.vo.hall.single.SingleHallForm;
import org.seec.muggle.auror.vo.hall.update.HallUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 影厅相关的控制器类
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
    @RequiresRoles("administrator")
    public ResponseEntity<?> addHall(@RequestBody SingleHallForm form) {
        hallService.addHall(form.getHallName(), form.getSeats());
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllHall() {
        SingleHallVO[] halls = hallService.getAllHalls();
        return ResponseEntity.ok(halls);
    }

    @PutMapping()
    @RequiresRoles("administrator")
    public ResponseEntity<?> updateHall(@RequestBody HallUpdateForm form) {
        hallService.updateHall(form.getHallId(), form.getHallName(), form.getSeats());
        return ResponseEntity.ok(null);
    }
}
