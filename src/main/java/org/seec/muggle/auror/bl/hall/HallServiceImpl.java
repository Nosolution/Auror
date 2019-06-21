package org.seec.muggle.auror.bl.hall;

import org.seec.muggle.auror.bl.scene.SceneService4Hall;
import org.seec.muggle.auror.dataservice.hall.HallMapper;
import org.seec.muggle.auror.entity.hall.Hall;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.HallPO;
import org.seec.muggle.auror.service.hall.HallService;
import org.seec.muggle.auror.vo.hall.all.SingleHallVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:05
 * @Version 1.0
 **/
@Service
public class HallServiceImpl implements HallService, HallService4Statistics, HallService4Order, HallService4Scene {
    @Autowired
    HallMapper hallMapper;

    @Autowired
    SceneService4Hall sceneService4Hall;


    @Override
    public void addHall(String name, int[][] seats) {
        String seat = getSeatsInString(seats);
        HallPO po = new HallPO();
        po.setHallName(name);
        po.setSeats(seat);
        hallMapper.insert(po);
    }

    @Override
    public int getSeatsNum(Long hallId) {
        HallPO po = hallMapper.get(hallId);
        return countString(po.getSeats(), "1");
    }

    private int countString(String str, String s) {
        int count = 0;
        while (str.contains(s)) {
            str = str.substring(str.indexOf(s) + 1);
            count++;
        }
        return count;
    }

    @Override
    public SingleHallVO[] getAllHalls() {
        List<HallPO> halls = hallMapper.getAll();

        List<SingleHallVO> vos = new ArrayList<>();
        halls.forEach(o -> {
            SingleHallVO vo = new SingleHallVO();
            vo.setHallId(o.getHallId());
            vo.setHallName(o.getHallName());
            vo.setSeats(getSeats(o.getSeats()));
            vos.add(vo);
        });
        return vos.toArray(new SingleHallVO[vos.size()]);
    }

    private Integer[][] getSeats(String seats) {
        String[] rows = seats.split(";");
        String[] columns = rows[0].split(",");
        Integer[][] hallSeats = new Integer[rows.length][columns.length];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for (int j = 0; j < columns.length; j++) {
                String[] rowUnits = row.split(",");
                hallSeats[i][j] = Integer.parseInt(rowUnits[j]);
            }
        }
        return hallSeats;
    }

    @Override
    public String getHallNameById(Long hallId) {
        HallPO po = hallMapper.get(hallId);
        return po.getHallName();
    }

    @Override
    public Hall getHallById(Long hallId) {
        HallPO po = hallMapper.get(hallId);
        Hall hall = new Hall();
        hall.setId(po.getHallId());
        hall.setName(po.getHallName());
        hall.setSeats(getSeats(po.getSeats()));
        return hall;
    }

    @Override
    public Long getHallIdByName(String hallName) {
        HallPO po = hallMapper.getHallByName(hallName);
        return po.getHallId();
    }

    @Override
    public void updateHall(Long id, String name, int[][] seats) {
        HallPO po = hallMapper.get(id);
        boolean isUsed = sceneService4Hall.isOccupied(po.getHallId());
        if (isUsed) {
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "该影厅有排片未完成");
        } else {
            po.setHallName(name);
            String seat = getSeatsInString(seats);
            po.setSeats(seat);
            hallMapper.update(po);
        }
    }

    private String getSeatsInString(int[][] seats) {
        String seat = "";
        StringBuilder stringBuilder = new StringBuilder(seat);
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                stringBuilder.append(seats[i][j]);
                if (j != seats[i].length - 1) {
                    stringBuilder.append(",");
                }
            }
            if (i != seats.length - 1) {
                stringBuilder.append(";");
            }
        }
        return stringBuilder.toString();
    }
}
