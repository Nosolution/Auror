package org.seec.muggle.auror.blImpl.strategy;

import org.seec.muggle.auror.bl.strategy.StrategyService;
import org.seec.muggle.auror.bl.strategy.StrategyService4Member;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.strategy.StrategyMapper;
import org.seec.muggle.auror.po.CouponPO;
import org.seec.muggle.auror.po.EventPO;
import org.seec.muggle.auror.po.MemberStrategyPO;
import org.seec.muggle.auror.po.RefundPO;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.strategy.event.EventForm;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVarietyVO;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:00
 * @Version 1.0
 **/
@Service
public class StrategyServiceImpl implements StrategyService, StrategyService4Order , StrategyService4Member {

    @Autowired
    StrategyMapper strategyMapper;

    @Override
    public RefundStrategyVO getRefundStrategy() {
        return new RefundStrategyVO(strategyMapper.selectRefundStrategy().get(0));
    }

    @Override
    public BasicVO updateRefundStrategy(Double rate, Integer beforeTime) {
        RefundPO po = new RefundPO(beforeTime,rate);
        strategyMapper.updateRefundStrategy(po);
        return new BasicVO();
    }
    @Override
    public RefundPO getRefund() {
        return strategyMapper.selectRefundStrategy().get(0);
    }

    @Override
    public BasicVO createMemberStrategy(String name, String url, Integer threshold, Double rate) {
        MemberStrategyPO  po = new MemberStrategyPO(name,url,threshold,rate);
        strategyMapper.insertMemberStrategy(po);
        return new BasicVO();
    }

    @Override
    public MemberVarietyVO[] getMemberStrategy() {
        List<MemberStrategyPO> strategyPOS = strategyMapper.selectAllMemberStrategys();
        if(strategyPOS.size()==0){
            return null;
        }
        else {
            List<MemberVarietyVO> vos = new ArrayList<>();
            strategyPOS.stream().forEach(o->{
                MemberVarietyVO vo  = new MemberVarietyVO();
                vo.setMemberDiscountRate(o.getRate());
                vo.setMemberPictureUrl(o.getUrl());
                vo.setPurchaseThreshold(o.getThreshold());
                vo.setMemberStrategyId(o.getId());
                vo.setMemberStrategyName(o.getName());
                vos.add(vo);
            });
            return vos.toArray(new MemberVarietyVO[vos.size()]);
        }

    }

    @Override
    public BasicVO createEvent(EventForm form) {
        EventPO po = new EventPO(form.getStartTime(),form.getEndTime(),form.getEventDescription(),form.getEventName());
        CouponPO couponPO = new CouponPO(form.getCouponName(),form.getCouponDescription(),form.getCouponDiscount(),form.getCouponThreshold(),form.getCouponPictureUrl());
        strategyMapper.insertCoupon(couponPO);

        po.setCouponId(couponPO.getId());
        strategyMapper.insertEvent(po);

        for(int i = 0;i<form.getMoviesIncluded().length;i++){
            strategyMapper.insertEventMovie(po.getId(),form.getMoviesIncluded()[i]);
        }
        return new BasicVO();
    }

    @Override
    public BasicVO deleteEvent(Long eventId) {
        strategyMapper.deleteEvent(eventId);
        strategyMapper.deleteEventMovie(eventId);
        return new BasicVO();
    }

    @Override
    public EventVO[] getEvents() {
        List<EventPO> events = strategyMapper.selectEvents();
        List<EventVO> res = new ArrayList<>();
        events.stream().forEach(o->{
            EventVO vo = new EventVO(o,strategyMapper.selectCouponById(o.getCouponId()),strategyMapper.selectMoviesByEventId(o.getId()));
            res.add(vo);
        });
        return res.toArray(new EventVO[res.size()]);
    }

    @Override
    public MemberStrategyPO getMemberStrategyById(Long id) {
        return strategyMapper.selectMemberStrategyById(id);
    }

    @Override
    public BasicVO deleteMemberStrategy(Long strategyId) {
        List<Long> isInUsed = strategyMapper.selectUsersByMemberStrategyId(strategyId);
        if(isInUsed.size() ==0){
            strategyMapper.deleteMemberStrategy(strategyId);
            BasicVO vo = new BasicVO();
            vo.setSucc(true);
            return vo;
        }
        else {
            BasicVO vo = new BasicVO();
            vo.setSucc(false);
            String using = "";
            StringBuffer buffer = new StringBuffer(using);
            isInUsed.stream().forEach(o->{
                buffer.append("用户: ");
                buffer.append(String.valueOf(o));
            });
            buffer.append("正处于该策略中，操作失败");
            vo.setMsg(buffer.toString());
            return vo;
        }
    }

    @Override
    public BasicVO updateMemberStrategy(MemberVaryForm form) {
        List<Long> isInUsed = strategyMapper.selectUsersByMemberStrategyId(form.getMemberStrategyId());
        if(isInUsed.size() ==0){
            strategyMapper.updateMemberStrategy(form);
            BasicVO vo = new BasicVO();
            vo.setSucc(true);
            return vo;
        }
        else {
            BasicVO vo = new BasicVO();
            vo.setSucc(false);
            String using = "";
            StringBuffer buffer = new StringBuffer(using);
            isInUsed.stream().forEach(o->{
                buffer.append("用户: ");
                buffer.append(String.valueOf(o));
            });
            buffer.append("正处于该策略中，操作失败");
            vo.setMsg(buffer.toString());
            return vo;
        }
    }
}
