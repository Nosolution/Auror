package org.seec.muggle.auror.blimpl.deal;

import org.seec.muggle.auror.bl.deal.*;
import org.seec.muggle.auror.bl.hall.HallService4Order;
import org.seec.muggle.auror.bl.member.MemberService4Order;
import org.seec.muggle.auror.bl.movie.MovieService4Order;
import org.seec.muggle.auror.bl.scene.SceneService4Order;
import org.seec.muggle.auror.bl.strategy.StrategyService4Order;
import org.seec.muggle.auror.dao.order.OrderMapper;
import org.seec.muggle.auror.entity.member.Member;
import org.seec.muggle.auror.entity.movie.Movie4Order;
import org.seec.muggle.auror.entity.scene.Scene;
import org.seec.muggle.auror.exception.BaseException;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.util.CaptchaUtil;
import org.seec.muggle.auror.util.DateUtil;
import org.seec.muggle.auror.vo.order.member.CouponsAcquirementVO;
import org.seec.muggle.auror.vo.order.member.MemberPaymentVO;
import org.seec.muggle.auror.vo.order.member.PaymentForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeForm;
import org.seec.muggle.auror.vo.order.recharge.RechargeVO;
import org.seec.muggle.auror.vo.order.rechargehistory.RechargeHistoryVO;
import org.seec.muggle.auror.vo.order.thirdparty.ThirdPartyPaymentVO;
import org.seec.muggle.auror.vo.order.ticket.TicketDetailVO;
import org.seec.muggle.auror.vo.order.unfinished.AvailableCouponsVO;
import org.seec.muggle.auror.vo.order.unfinished.UnfinishedOrderVO;
import org.seec.muggle.auror.vo.seatselection.SeatsSelectionVO;
import org.seec.muggle.auror.vo.seatselection.SelectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        po.setStatus(2);
        Integer cost = selectedSeats.length * sceneService4Order.getPriceByScene(sceneId);
        po.setCost(cost);
        po.setMovieId(sceneService4Order.getMovieIdByScene(sceneId));
        orderMapper.insertOrder(po);

        for (SelectionForm selectedSeat : selectedSeats) {
            orderMapper.insertSeat(new TicketPO(sceneId, selectedSeat.getRow(), selectedSeat.getColumn(), po.getId()));
        }

        vo.setOrderId(po.getId());
        vo.setInitTime(DateUtil.timestampToString(po.getCreateTime()));
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
    public void cancelOrder(Long orderId) {
        orderMapper.cancelOrder(orderId);
        orderMapper.deleteSeat(orderId);
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
        Integer cost = orderMapper.getOrderById(orderId).getCost();
        RefundPO refundStrategy = strategyService4Order.getRefund();
        Double amount = refundStrategy.getRate() * (double) cost;
        orderMapper.cancelOrder(orderId);
        orderMapper.deleteSeat(orderId);
        return amount;
    }

    @Override
    public int getNumsBySceneId(Long sceneId) {
        return orderMapper.TicketNumsBySceneId(sceneId);
    }

    @Override
    public void purchaseMember(Long userId, Integer cost, Long memberId) {
        orderMapper.insertMember(memberId, userId, cost);
        RechargePO rechargePO = new RechargePO();
        rechargePO.setCost(cost);
        rechargePO.setUserId(userId);
        rechargePO.setInitTime(Timestamp.valueOf(LocalDateTime.now()));
        rechargePO.setType(1);
        orderMapper.insertRecharge(rechargePO);

    }

    @Override
    public boolean hasSeen(Long userId, List<Long> sceneIds) {
        for (Long sceneId : sceneIds) {
            if (orderMapper.getOrderByUserIdAndSceneId(userId, sceneId) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UnfinishedOrderVO checkUnfinishedOrder(Long orderId) {
        OrderPO orderPO = orderMapper.getOrderById(orderId);
        Scene scene = sceneService4Order.getSceneById(orderPO.getSceneId());
        String hallName = hallService4Order.getHallNameById(scene.getHallId());
        List<TicketPO> ticketPOS = orderMapper.getSeatsById(orderId);
        List<AvailableCouponsVO> couponPOS = strategyService4Order.getCouponsByCost(ticketPOS.size() * scene.getPrice(), orderPO.getUserId());
        couponPOS.sort(Comparator.comparing(AvailableCouponsVO::getEndTime));

        UnfinishedOrderVO vo = new UnfinishedOrderVO(orderPO, scene, hallName, ticketPOS, couponPOS, movieService4Order.getMovieNameById(scene.getMovieId()));
        return vo;
    }

    @Override
    public Integer getBoxOffice(Long movieId) {
        return orderMapper.sumBoxOffice(movieId);
    }

    @Override
    public RechargeVO rechargeMember(RechargeForm form, Long userId) {
        List<MemberStrategyPO> strategyPOS = strategyService4Order.selectAllMemberStrategy();

        Member member = memberService4Order.getMemberByUserId(userId);
        MemberStrategyPO po = null;
        Optional<Integer> recharge = Optional.ofNullable(orderMapper.sumRecharge(userId));
        int rechargeTotal = recharge.orElse(0);
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
        memberService4Order.recharge(userId, form.getCost());

        if (po == null) { //说明已经是至高会员了
            po = strategyPOS.get(strategyPOS.size() - 1);
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(!po.getId().equals(member.getStrategyId()));
            if (!po.getId().equals(member.getStrategyId())) {
                memberService4Order.changeStrategy(userId, po.getId());
            }
            vo.setCredit(form.getCost() + member.getCredit());
            vo.setNewMemberDiscountRate(strategyPOS.get(strategyPOS.size() - 1).getRate());
            vo.setNewMemberPictureUrl(strategyPOS.get(strategyPOS.size() - 1).getUrl());
            vo.setNewMemberStrategyName(strategyPOS.get(strategyPOS.size() - 1).getName());
            return vo;
        } else if (po.getId().equals(member.getStrategyId())) {
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(false);
            vo.setCredit(form.getCost() + member.getCredit());
            vo.setNewMemberDiscountRate(po.getRate());
            vo.setNewMemberPictureUrl(po.getUrl());
            vo.setNewMemberStrategyName(po.getName());
            return vo;
        } else {
            RechargeVO vo = new RechargeVO();
            vo.setUpgraded(true);
            vo.setCredit(form.getCost() + member.getCredit());
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

        recharges.stream()
                .sorted(Comparator.comparing(RechargePO::getInitTime).reversed())
                .forEach(o -> {
                    RechargeHistoryVO vo = new RechargeHistoryVO();
                    vo.setCost(o.getCost());
                    vo.setTime(DateUtil.timestampToString(o.getInitTime()));
                    vos.add(vo);
                });

        return vos.toArray(new RechargeHistoryVO[vos.size()]);
    }

    @Override
    public List<TicketPO> getTicketsBySceneId(Long sceneId) {
        return orderMapper.getSeatsBySceneId(sceneId);
    }

    @Override
    public Integer getConsumptionByUser(Long userId) {
        return orderMapper.getAllPayment(userId);

    }

    @Override
    public ThirdPartyPaymentVO finishByThird_party(PaymentForm form) {
        OrderPO orderPO = orderMapper.getOrderById(form.getOrderId());
        Integer payment = getPayment(form, orderPO);
        orderMapper.finishOrder(form.getOrderId(), payment, 2);

        List<CouponsAcquirementVO> acquirementVOS = getAcquirementVOS(orderPO);
        ThirdPartyPaymentVO thirdPartyPaymentVO = new ThirdPartyPaymentVO();
        thirdPartyPaymentVO.setCouponsGot(acquirementVOS.toArray(new CouponsAcquirementVO[acquirementVOS.size()]));
        return thirdPartyPaymentVO;
    }

    @Override
    public MemberPaymentVO finishByMember(PaymentForm form) {
        OrderPO orderPO = orderMapper.getOrderById(form.getOrderId());
        Integer payment = getPayment(form, orderPO);

        //判断余额是否足够支付
        int pay = memberService4Order.payByMember(orderPO.getUserId(), payment);
        if (pay == -1) {
            throw new BaseException(HttpStatus.METHOD_NOT_ALLOWED, "会员卡余额不足");
        }

        orderMapper.finishOrder(form.getOrderId(), pay, 1);
//根据实际支付情况进行优惠券赠送。
        orderPO = orderMapper.getOrderById(form.getOrderId());

        List<CouponsAcquirementVO> acquirementVOS = getAcquirementVOS(orderPO);
        MemberPaymentVO voFinal = new MemberPaymentVO();
        voFinal.setCouponsGot(acquirementVOS.toArray(new CouponsAcquirementVO[acquirementVOS.size()]));
        return voFinal;
    }


    private Integer getPayment(PaymentForm form, OrderPO orderPO) {
        Integer cost;
        if (form.getCoupons() == null) {
            cost = 0;
        } else {
            cost = strategyService4Order.cutDownByCoupons(form.getCoupons(), orderPO.getUserId());
        }

        Integer payment = (orderPO.getCost() - cost) > 0 ? orderPO.getCost() - cost : 0;
        return payment;

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
        List<OrderPO> orders = orderMapper.getAllOrdersByUser(userId);
        List<TicketDetailVO> vos = new ArrayList<>();
        if (orders.size() == 0) {
            return new TicketDetailVO[0];
        }
        orders.stream()
                .sorted(Comparator.comparing(OrderPO::getCreateTime).reversed())
                .forEach(o -> {
                    List<TicketPO> ticketPOS = orderMapper.getSeatsById(o.getId());
                    Scene scene = sceneService4Order.getSceneById(o.getSceneId());
                    Movie4Order movie = movieService4Order.getMovieInfoByIdForOrder(o.getMovieId());
                    RefundPO refundPO = strategyService4Order.getRefund();
                    String hallName = hallService4Order.getHallNameById(scene.getHallId());
                    int status = o.getStatus();
                    if (status == 1) { // 已支付
                        LocalDateTime today = LocalDateTime.now();
                        LocalDateTime lastAvailableTime = scene.getStartTime().toLocalDateTime();
                        lastAvailableTime = lastAvailableTime.minusHours(refundPO.getBeforeTime());
                        if (today.isAfter(lastAvailableTime)) {
                            status = 0;
                        }
                    }
                    TicketDetailVO vo = new TicketDetailVO(scene, movie, status, ticketPOS, o, hallName);
                    vos.add(vo);
                });

        return vos.toArray(new TicketDetailVO[vos.size()]);
    }
}
