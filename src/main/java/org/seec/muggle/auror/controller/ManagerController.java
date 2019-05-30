package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.vo.personnel.ManagerForm;
import org.seec.muggle.auror.vo.personnel.ManagerIdForm;
import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:12
 * @Version 1.0
 **/
@CrossOrigin
@RestController(value = "/api")
public class ManagerController {

    @PostMapping(value = "/personnel/manager")
    public ResponseEntity<?> addManager(@RequestBody ManagerForm form){
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "/personnel/manager")
    public ResponseEntity<?> removeManager(@RequestBody ManagerIdForm form){
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/personnel/manager_list")
    public ResponseEntity<?> getAllManagers(){
        return ResponseEntity.ok(new ManagerInfoVO[]{});
    }
}
