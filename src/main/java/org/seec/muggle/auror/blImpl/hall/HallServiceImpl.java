package org.seec.muggle.auror.blImpl.hall;

import org.seec.muggle.auror.bl.hall.HallService;
import org.seec.muggle.auror.bl.hall.HallService4Order;
import org.seec.muggle.auror.bl.hall.HallService4Scene;
import org.seec.muggle.auror.bl.hall.HallService4Statistics;
import org.seec.muggle.auror.dao.hall.HallMapper;
import org.seec.muggle.auror.po.Hall;
import org.seec.muggle.auror.po.HallPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.hall.all.SingleHallVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public BasicVO addHall(String name, int[][] seats) {
        BasicVO vo = new BasicVO();
        String seat = "";
        StringBuilder stringBuilder = new StringBuilder(seat);
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                stringBuilder.append(String.valueOf(seats[i][j]));
                if (j != seats[i].length - 1) {
                    stringBuilder.append(",");
                }
            }
            if (i != seats.length - 1) {
                stringBuilder.append(";");
            }
        }
        hallMapper.insertNewHall(name, stringBuilder.toString());
        return vo;
    }

    @Override
    public int getSeatsNum(Long hallId) {
        HallPO PO = hallMapper.findHallById(hallId);
        return countString(PO.getSeats(), "1");
    }

    private int countString(String str, String s) {
        int count = 0, len = str.length();
        while (str.contains(s)) {
            str = str.substring(str.indexOf(s) + 1, str.length());
            count++;
        }
        return count;
    }

    @Override
    public SingleHallVO[] getHalls() {
        List<HallPO> halls = hallMapper.selectAll();

        List<SingleHallVO> vos = new ArrayList<>();
        halls.stream().forEach(o -> {
            SingleHallVO vo = new SingleHallVO();
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
    public HallPO selectHallById(Long hallId) {
        HallPO po = hallMapper.findHallById(hallId);
        return po;
    }

    @Override
    public Hall getHallById(Long hallId) {
        HallPO po = hallMapper.findHallById(hallId);
        Hall hall = new Hall();
        hall.setId(po.getHallId());
        hall.setName(po.getHallName());
        hall.setSeats(getSeats(po.getSeats()));
        return hall;
    }
}
