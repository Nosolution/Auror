package org.seec.muggle.auror.blImpl.deal;

import org.seec.muggle.auror.bl.deal.*;
import org.seec.muggle.auror.bl.hall.HallService4Order;
import org.seec.muggle.auror.bl.member.MemberService4Order;
import org.seec.muggle.auror.bl.movie.MovieService4Order;
import org.seec.muggle.auror.bl.scene.SceneService4Order;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.order.OrderMapper;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.CaptchaUtil;
import org.seec.muggle.auror.vo.BasicVO;
import org.seec.muggle.auror.vo.order.member.CouponsAcquirementVO;
import org.seec.muggle.auror.vo.order.member.MemberPaymentForm;
import org.seec.muggle.auror.vo.order.member.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.recharge.RechargeForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeVO;
import org.seec.muggle.auror.vo.order.recharge_history.RechargeHistoryVO;
import org.seec.muggle.auror.vo.order.third_party.ThirdPartyPaymentForm;
import org.seec.muggle.auror.vo.order.third_party.ThirdPartyPaymentVO;
import org.seec.muggle.auror.vo.order.ticket.TicketDetailVO;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 12:00
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService, OrderService4Statistics, OrderService4Mark, OrderService4Scene, OrderService4Account {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    MemberService4Order memberService4Order;

    @Autowired
    SceneService4Order sceneService4Order;

    @Autowired
    StrategyService4Order strategyService4Order;

    @Autowired
    HallService4Order hallService4Order;

    @Autowired
    MovieService4Order movieService4Order;

    @Override
    public SeatsSelectionVO selectSeats(Long sceneId, Long userId, SelectionForm[] selectedSeats) {

        SeatsSelectionVO vo = new SeatsSelectionVO();

        OrderPO po = new OrderPO();
        po.setCode(CaptchaUtil.getCaptcha());
        po.setUserId(userId);
        po.setCreateTime(new Timestamp(System.currentTimeMillis()));
        po.setSceneId(sceneId);
        po.setStatus(0);
        Integer cost = selectedSeats.length * sceneService4Order.getPriceByScene(sceneId);
        po.setCost(cost);
        po.setMovieId(sceneService4Order.getMovieIdByScene(sceneId));
        orderMapper.insertOrder(po);

        for (int i = 0; i < selectedSeats.length; i++) {
            orderMapper.insertSeat(new TicketPO(sceneId, selectedSeats[i].getRow(), selectedSeats[i].getColumn(),po.getId()));
        }

        vo.setOrderId(po.getId());
        vo.setInitTime(po.getCreateTime());
        vo.setTicketNum(selectedSeats.length);
        vo.setCost(cost);
        return vo;
    }

    /**
     * @return org.seec.muggle.auror.vo.BasicVO
     * @Author jyh
     * @Description //修正cancel的时候没有取消座位的Bug
     * @Date 17:15 2019/6/8
     * @Param [orderId]
     **/
    @Override
    public BasicVO cancelOrder(Long orderId) {
        orderMapper.cancelOrder(orderId);
        orderMapper.deleteSeat(orderId);
        return new BasicVO();
    }


    /**
     * @return java.lang.Double
     * @Author jyh
     * @Description //同上
     * @Date 17:15 2019/6/8
     * @Param [orderId]
     **/
    @Override
    public Double refundOrder(Long orderId) {
        Integer cost = orderMapper.findOrderById(orderId).getCost();
        RefundPO refundStrategy = strategyService4Order.getRefund();
        Double amount = refundStrategy.getRate() * (double) cost;
        orderMapper.cancelOrder(orderId);
        orderMapper.deleteSeat(orderId);
        return amount;
    }

    @Override
    public int getNumsBySceneId(Long sceneId) {
        return orderMapper.orderNumsBySceneId(sceneId);
    }

    @Override
    public BasicVO purchaseMember(Long userId, Integer cost, Long memberId) {
        orderMapper.insertMember(memberId, userId, cost);
        RechargePO rechargePO = new RechargePO();
        rechargePO.setCost(cost);
        rechargePO.setUserId(userId);
        rechargePO.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        rechargePO.setType(1);
        orderMapper.insertRecharge(rechargePO);
        return new BasicVO();
    }

    @Override
    public int hasSeen(Long userId, List<ScenePO> sceneId) {
        for (ScenePO scenePO : sceneId) {
            if (orderMapper.findOrderByUserIdAndSceneId(userId, scenePO.getId()) != null) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public UnfinishedOrderVO checkUnfinishedOrder(Long orderId) {
        OrderPO orderPO = orderMapper.findOrderById(orderId);
        ScenePO scenePO = sceneService4Order.selectSceneByID(orderPO.getSceneId());
        HallPO hallPO = hallService4Order.selectHallById(scenePO.getHallId());
        List<TicketPO> ticketPOS = orderMapper.findSeatsById(orderId);
        List<AvailableCouponsVO> couponPOS = strategyService4Order.getCouponsByCost(ticketPOS.size() * scenePO.getPrice(), orderPO.getUserId());

        UnfinishedOrderVO vo = new UnfinishedOrderVO(orderPO, scenePO, hallPO, ticketPOS, couponPOS, movieService4Order.getMovieNameById(scenePO.getMovieId()));
        return vo;
    }

    @Override
    public Integer getBoxOffice(Long movieId) {
        return orderMapper.sumBoxOffice(movieId);
    }

    @Override
    public RechargeVO rechargeMember(RechargeForm form, Long userId) {
        List<MemberStrategyPO> strategyPOS = strategyService4Order.selectAllMemberStrategy();

        MemberPO memberPO = memberService4Order.getMemberByUserId(userId);
        MemberStrategyPO po = null;
        int rechargeTotal = orderMapper.sumRecharge(userId);
        for (int i = 0; i < strategyPOS.size(); i++) {
            if (strategyPOS.get(i).getThreshold() > rechargeTotal + form.getCost()) {
                po = strategyPOS.get(i - 1);
                break;
            }
        }

        //充钱
        RechargePO rechargePO = new RechargePO();
        rechargePO.setCost(form.getCost());
        rechargePO.setUserId(userId);
        rechargePO.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        rechargePO.setType(2);
        orderMapper.insertRecharge(rechargePO);
        memberService4Order.recharge(form.getCost(), userId);

        if (po == null) { //说明已经是至高会员了
            po = strategyPOS.get(strategyPOS.size() - 1);
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(po.getId()!=memberPO.getStrategyId());
            if(po.getId()!=memberPO.getStrategyId()) {
                memberService4Order.changeStrategy(userId, po.getId());
            }
            vo.setCredit(form.getCost() + memberPO.getCredit());
            vo.setNewMemberDiscountRate(strategyPOS.get(strategyPOS.size() - 1).getRate());
            vo.setNewMemberPictureUrl(strategyPOS.get(strategyPOS.size() - 1).getUrl());
            vo.setNewMemberStrategyName(strategyPOS.get(strategyPOS.size() - 1).getName());
            return vo;
        } else if (po.getId().equals(memberPO.getStrategyId())) {
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(false);
            vo.setCredit(form.getCost() + memberPO.getCredit());
            vo.setNewMemberDiscountRate(po.getRate());
            vo.setNewMemberPictureUrl(po.getUrl());
            vo.setNewMemberStrategyName(po.getName());
            return vo;
        } else {
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(true);
            vo.setCredit(form.getCost() + memberPO.getCredit());
            vo.setNewMemberDiscountRate(po.getRate());
            vo.setNewMemberPictureUrl(po.getUrl());
            vo.setNewMemberStrategyName(po.getName());
            memberService4Order.changeStrategy(userId, po.getId());
            return vo;
        }
    }

    @Override
    public RechargeHistoryVO[] getRechargeHistory(Long userId) {
        List<RechargePO> recharges = orderMapper.selectRechargesById(userId);
        List<RechargeHistoryVO> vos = new ArrayList<>();
        recharges.forEach(o -> {
            RechargeHistoryVO vo = new RechargeHistoryVO();
            vo.setCost(o.getCost());
            vo.setTime(o.getInitTime());
            vos.add(vo);
        });
        return vos.toArray(new RechargeHistoryVO[vos.size()]);
    }

    @Override
    public List<TicketPO> getTicketsBySceneId(Long sceneId) {
        return orderMapper.findSeatsBySceneId(sceneId);
    }

    @Override
    public Integer getConsumptionByUser(Long userId) {
        return orderMapper.getAllPayment(userId);

    }

    @Override
    public ThirdPartyPaymentVO finishByThird_party(ThirdPartyPaymentForm form) {
        OrderPO orderPO = orderMapper.findOrderById(form.getOrderId());
        Integer cost = strategyService4Order.cutDownByCoupons(form.getCoupons(), orderPO.getUserId());

        Integer payment = (orderPO.getCost() - cost) > 0 ? orderPO.getCost() - cost : 0;
        orderMapper.finishOrder(form.getOrderId(), payment, 2);

        List<CouponsAcquirementVO> acquirementVOS = getAcquirementVOS(orderPO);
        ThirdPartyPaymentVO thirdPartyPaymentVO = new ThirdPartyPaymentVO();
        thirdPartyPaymentVO.setCouponsGot(acquirementVOS.toArray(new CouponsAcquirementVO[acquirementVOS.size()]));
        return thirdPartyPaymentVO;
    }

    @Override
    public MemberPaymentVO finishByMember(MemberPaymentForm form) {
        OrderPO orderPO = orderMapper.findOrderById(form.getOrderId());
        Integer cost = strategyService4Order.cutDownByCoupons(form.getCoupons(), orderPO.getUserId());

        Integer payment = (orderPO.getCost() - cost) > 0 ? orderPO.getCost() - cost : 0;
        //判断余额是否足够支付
        if (!memberService4Order.payByMember(payment, orderPO.getUserId())) {
            return null;
        }

        orderMapper.finishOrder(form.getOrderId(), payment, 1);

        List<CouponsAcquirementVO> acquirementVOS = getAcquirementVOS(orderPO);
        MemberPaymentVO voFinal = new MemberPaymentVO();
        voFinal.setCouponsGot(acquirementVOS.toArray(new CouponsAcquirementVO[acquirementVOS.size()]));
        return voFinal;
    }

    private List<CouponsAcquirementVO> getAcquirementVOS(OrderPO orderPO) {
        List<CouponPO> couponPOS = strategyService4Order.sendCoupons(orderPO.getMovieId(), orderPO.getUserId());
        List<CouponsAcquirementVO> acquirementVOS = new ArrayList<>();
        couponPOS.forEach(o -> {
            CouponsAcquirementVO vo = new CouponsAcquirementVO();
            vo.setCouponId(o.getId());
            vo.setCouponDescription(o.getDescription());
            vo.setCouponDiscount(o.getDiscount());
            vo.setCouponName(o.getCouponName());
            vo.setCouponPictureUrl(o.getUrl());
            acquirementVOS.add(vo);
        });
        return acquirementVOS;
    }

    @Override
    public TicketDetailVO[] getAllOrders(Long userId) {
        List<OrderPO> orders = orderMapper.findAllOrdersByUser(userId);
        List<TicketDetailVO> vos = new ArrayList<>();
        orders.forEach(o -> {
            List<TicketPO> ticketPOS = orderMapper.findSeatsById(o.getId());
            ScenePO scene = sceneService4Order.selectSceneByID(o.getSceneId());
            MoviePO movie = movieService4Order.getMovieById(o.getMovieId());
            RefundPO refundPO = strategyService4Order.getRefund();
            HallPO hall = hallService4Order.selectHallById(scene.getHallId());
            int status = o.getStatus();
            if (status == 1) {
                LocalDateTime today = LocalDateTime.now();
                LocalDateTime lastAvaliabeTime = scene.getStartTime().toLocalDateTime();
                lastAvaliabeTime = lastAvaliabeTime.minusHours(refundPO.getBeforeTime());
                status = 3;
            }
            TicketDetailVO vo = new TicketDetailVO(scene, movie, status, ticketPOS, o, hall);
            vos.add(vo);
        });
        return vos.toArray(new TicketDetailVO[vos.size()]);
    }
}
