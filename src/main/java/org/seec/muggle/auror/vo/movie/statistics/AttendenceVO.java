package org.seec.muggle.auror.vo.movie.statistics;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 23:03
 * @Version 1.0
 **/
public class AttendenceVO {
    String date;
    Double attendanceRate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(Double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
}
