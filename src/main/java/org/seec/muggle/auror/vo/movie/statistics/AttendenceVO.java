package org.seec.muggle.auror.vo.movie.statistics;

import lombok.Data;
import org.seec.muggle.auror.util.DateUtil;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:03
 * @Version 1.0
 **/
@Data
public class AttendenceVO {
    String date;
    Double attendanceRate;

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = DateUtil.dateToString(date);
    }

    public Double getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(Double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
}
