package org.seec.muggle.auror.blImpl.hall;

import com.sun.org.apache.regexp.internal.RE;
import org.seec.muggle.auror.bl.hall.HallService;
import org.seec.muggle.auror.bl.hall.HallService4Statistics;
import org.seec.muggle.auror.dao.hall.HallMapper;
import org.seec.muggle.auror.po.HallPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/4 21:05
 * @Version 1.0
 **/
@Service
public class HallServiceImpl implements HallService , HallService4Statistics {
    @Autowired
    HallMapper hallMapper;

    @Override
    public BasicVO addHall(String name, int[][] seats) {
        BasicVO vo = new BasicVO();
        String seat = "";
        StringBuffer stringBuffer = new StringBuffer(seat);
        for(int i =0;i<seats.length;i++){
            for(int j = 0;j<seats[i].length;j++){
                stringBuffer.append(String.valueOf(seats[i][j]));
                if(j!=seats[i].length-1){
                    stringBuffer.append(",");
                }
            }
            if(i!=seats.length-1){
                stringBuffer.append(";");
            }
        }
        hallMapper.insertNewHall(name,stringBuffer.toString());
        return vo;
    }

    @Override
    public int getSeatsNum(Long hallId) {
        HallPO PO = hallMapper.findHallById(hallId);
        return countString(PO.getSeats(),"1");
    }

    private int countString(String str,String s) {
        int count = 0, len = str.length();
        while (str.indexOf(s) != -1) {
            str = str.substring(str.indexOf(s) + 1, str.length());
            count++;
        }
        return count;
    }
}
