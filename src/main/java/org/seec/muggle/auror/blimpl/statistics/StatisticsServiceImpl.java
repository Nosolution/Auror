package org.seec.muggle.auror.blimpl.statistics;

import org.seec.muggle.auror.bl.deal.OrderService4Statistics;
import org.seec.muggle.auror.bl.hall.HallService4Statistics;
import org.seec.muggle.auror.bl.scene.SceneService4Statistics;
import org.seec.muggle.auror.bl.statistics.StatisticsService;
import org.seec.muggle.auror.bl.statistics.StatisticsService4Movie;
import org.seec.muggle.auror.po.AttendInfo;
import org.seec.muggle.auror.po.ScenePO;
import org.seec.muggle.auror.vo.movie.statistics.AttendenceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/6 19:40
 * @Version 1.0
 **/
@Service
public class StatisticsServiceImpl implements StatisticsService, StatisticsService4Movie {

    @Autowired
    SceneService4Statistics sceneService4Statistics;

    @Autowired
    HallService4Statistics hallService4Statistics;

    @Autowired
    OrderService4Statistics orderService4Statistics;

    @Override
    public AttendenceVO[] getBoxOfficeRate(Long movieId) {
        List<ScenePO> scenes = sceneService4Statistics.getScenesByMovieId(movieId);
        if (scenes.size() == 0) {
            return new AttendenceVO[]{};
        } else {
            scenes.sort(Comparator.comparing(ScenePO::getDate));
            List<AttendInfo> attendInfos = new ArrayList<>();
            int pos = 0;
            AttendInfo info = new AttendInfo(scenes.get(0).getDate(), hallService4Statistics.getSeatsNum(scenes.get(0).getHallId()), orderService4Statistics.getNumsBySceneId(scenes.get(0).getId()));
            attendInfos.add(info);
            for (int i = 1; i < scenes.size(); i++) {
                info = new AttendInfo();
                ScenePO current = scenes.get(i);
                if (current.getDate().equals(scenes.get(i - 1).getDate())) {
                    info = attendInfos.get(pos);
                    info.setOrders(info.getOrders() + orderService4Statistics.getNumsBySceneId(current.getId()));
                    info.setSeats(info.getSeats() + hallService4Statistics.getSeatsNum(current.getHallId()));
                    attendInfos.set(pos, info);
                } else {
                    info.setSeats(hallService4Statistics.getSeatsNum(current.getHallId()));
                    info.setOrders(orderService4Statistics.getNumsBySceneId(current.getId()));
                    info.setDate(current.getDate());
                    attendInfos.add(info);
                    pos++;
                }

            }

            List<AttendenceVO> vos = new ArrayList<>();
            attendInfos.forEach(o -> {
                AttendenceVO vo = new AttendenceVO();
                vo.setDate(o.getDate());
                vo.setAttendanceRate((double) o.getOrders() / o.getSeats());
                vos.add(vo);
            });
            return vos.toArray(new AttendenceVO[vos.size()]);
        }
    }

    @Override
    public Integer getBoxOffice(Long movieId) {
        return orderService4Statistics.getBoxOffice(movieId);
    }
}
