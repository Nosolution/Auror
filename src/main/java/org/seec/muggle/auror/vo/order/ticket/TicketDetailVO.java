package org.seec.muggle.auror.vo.order.ticket;

import lombok.Data;
import org.seec.muggle.auror.entity.movie.Movie4Order;
import org.seec.muggle.auror.entity.scene.Scene;
import org.seec.muggle.auror.po.OrderPO;
import org.seec.muggle.auror.po.TicketPO;
import org.seec.muggle.auror.util.DateConverterUtil;
import org.seec.muggle.auror.vo.IntervalVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/5/29 20:30
 * @Version 1.0
 **/
@Data
public class TicketDetailVO {
    Long orderId;
    String movieName;
    String moviePosterUrl;
    String hallName;
    String date;
    IntervalVO interval;
    Integer status; //0: 未完成 1: 已完成 2: 已失效
    Integer cost;
    String ticketCode;//取票码
    SelectionForm[] selectedSeats;
    Integer ticketNum;
    Timestamp initTime;


    public TicketDetailVO(Scene scene, Movie4Order movie, int status, List<TicketPO> ticketPOS, OrderPO order, String hallName) {
        this.orderId = order.getId();
        this.movieName = movie.getMovieName();
        this.moviePosterUrl = movie.getPosterUrl();
        this.hallName = hallName;
        this.date = DateConverterUtil.dateToString(scene.getDate());
        this.interval = new IntervalVO(scene.getStartTime(), scene.getEndTime());
        this.status = status;
        this.cost = order.getCost();
        this.ticketCode = order.getCode();
        this.selectedSeats = new SelectionForm[ticketPOS.size()];
        for (int i = 0; i < selectedSeats.length; i++) {
            selectedSeats[i] = new SelectionForm();
            selectedSeats[i].setRow(ticketPOS.get(i).getRow());
            selectedSeats[i].setColumn(ticketPOS.get(i).getColumn());
        }
        this.ticketNum = ticketPOS.size();
        this.initTime = order.getCreateTime();
    }
}
