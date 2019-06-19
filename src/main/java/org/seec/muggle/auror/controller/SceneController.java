package org.seec.muggle.auror.controller;

import org.seec.muggle.auror.service.order.OrderService;
import org.seec.muggle.auror.service.scene.SceneService;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.util.JwtUtil;
import org.seec.muggle.auror.vo.scene.Info.InfoVO;
import org.seec.muggle.auror.vo.scene.addition.SceneAdditionForm;
import org.seec.muggle.auror.vo.scene.movie.MovieSceneInfoVO;
import org.seec.muggle.auror.vo.scene.vary.SceneVaryForm;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionForm;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 17:00
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/api/scene")
public class SceneController {

    @Autowired
    SceneService sceneService;
    @Autowired
    OrderService orderService;
    @Autowired
    JwtUtil jwtUtil;
    @Value("${jwt.header}")
    String tokenHeader;


    @GetMapping(value = "/info/of_movie")
    public ResponseEntity<?> sceneInfoByMovie(@PathParam("movieid") Long movieId) {
        MovieSceneInfoVO[] infoVOS = sceneService.getScenesInfoByMovieId(movieId);
        return ResponseEntity.ok(infoVOS);
    }

    @PostMapping(value = "/order/seat/selection")
    public ResponseEntity<?> seatSelection(@RequestBody SeatsSelectionForm form, HttpServletRequest request) {
        Long id = getIdFromRequest(request);
        SeatsSelectionVO vo = orderService.selectSeats(form.getSceneId(), id, form.getSelectedSeats());
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/info/of_hall")
    public ResponseEntity<?> getSceneInfoByHallIdAndDate(@PathParam("hallName") String hallName, @PathParam("date") String date) {
        Date date1 = DateUtil.stringToDate(date);
        InfoVO[] infoVOS = sceneService.getScenesInfoByHallNameAndDate(
                hallName, date1);
        return ResponseEntity.ok(infoVOS);
    }

    @PostMapping()
    public ResponseEntity addMovieScene(@RequestBody SceneAdditionForm form) {
        sceneService.addScene(form.getMovieId(), form.getHallName(), form.getDate(), form.getStartTime(), form.getPrice());
        return ResponseEntity.ok(null);
    }

    @PutMapping()
    public ResponseEntity updateMovieScene(@RequestBody SceneVaryForm form) {
        sceneService.updateScene(form.getSceneId(), form.getHallName(), DateUtil.stringToDate(form.getDate()), form.getStartTime(), form.getPrice());
        return ResponseEntity.ok(null);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteMovieScene(@RequestBody Long sceneId) {
        sceneService.deleteScene(sceneId);
        return ResponseEntity.ok(null);
    }

    private Long getIdFromRequest(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        return jwtUtil.getIdFromToken(token);
    }
}
