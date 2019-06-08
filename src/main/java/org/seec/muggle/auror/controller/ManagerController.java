package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.bl.manager.ManagerService;
import org.seec.muggle.auror.vo.personnel.ManagerForm;
import org.seec.muggle.auror.vo.personnel.ManagerIdForm;
import org.seec.muggle.auror.vo.personnel.ManagerInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:12
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api/personnel")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping(value = "/manager")
    public ResponseEntity<?> addManager(@RequestBody ManagerForm form){
        managerService.addManager(form.getUsername(),form.getPassword());
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "/manager")
    public ResponseEntity<?> removeManager(@RequestBody ManagerIdForm form){
        managerService.deleteManager(form.getManagerId());
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "/manager_list")
    public ResponseEntity<?> getAllManagers(){
        return ResponseEntity.ok(managerService.getManagers());
    }
}
