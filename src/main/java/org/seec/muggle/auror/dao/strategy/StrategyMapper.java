package org.seec.muggle.auror.dao.strategy;

import org.apache.ibatis.annotations.Param;
import org.seec.muggle.auror.annotation.DaoMapper;
import org.seec.muggle.auror.po.*;
import org.seec.muggle.auror.vo.strategy.member.MemberVaryForm;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 15:23
 * @Version 1.0
 **/
@DaoMapper
public interface StrategyMapper {
    List<RefundPO> selectRefundStrategy();

    int updateRefundStrategy(RefundPO po);

    int insertMemberStrategy(MemberStrategyPO po);

    List<MemberStrategyPO> selectAllMemberStrategies();

    MemberStrategyPO selectMemberStrategyById(Long id);

    int insertEvent(EventPO po);

    int insertCoupon(CouponPO po);

    int insertEventMovie(@Param("eventId")Long eventId,@Param("movieId")Long movieId);

    int deleteEvent(@Param("eventId") Long eventId);

    int deleteEventMovie(@Param("eventId")Long eventId);

    List<EventPO> selectEvents();

    CouponPO selectCouponById(@Param("couponId")Long couponId);

    EventPO selectEventsById(@Param("eventId")Long eventId);

    List<Long> selectMoviesByEventId(@Param("eventId")Long eventId);

    List<Long> selectCouponIdsByMovieId(@Param("movieId")Long movieId);

    List<Long> selectUsersByMemberStrategyId(Long strategyId);

    int deleteMemberStrategy(Long strategyId);

    int updateMemberStrategy(MemberVaryForm form);

    List<CouponPO> selectCouponByCost(Integer cost);

    List<Date> selectCouponsTimes(@Param("userId")Long userId, @Param("couponId")Long couponId);

    List<UserCouponPO> getUserCoupons(Long userId);

    int insertUserCoupon(UserCouponPO po);

    int deleteCouponUser(@Param("userId")Long userId,@Param("couponId")Long couponId);
}
