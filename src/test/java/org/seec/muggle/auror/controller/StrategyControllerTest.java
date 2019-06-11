package org.seec.muggle.auror.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seec.muggle.auror.vo.strategy.event.EventVO;
import org.seec.muggle.auror.vo.strategy.refund.RefundStrategyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void getRefundStrategy() {
        ResponseEntity<RefundStrategyVO> response = testRestTemplate.getForEntity("/api/strategy/refund", RefundStrategyVO.class);
        assertOK(response);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void varyRefundStrategy() {
    }

    @Test
    public void getStrategyEvents() {
        ResponseEntity<EventVO[]> response = testRestTemplate.getForEntity("/api/strategy/event", EventVO[].class);
        assertOK(response);
    }

    @Test
    public void addStrategyEvents() {
    }

    @Test
    public void deleteEvent() {
    }

    @Test
    public void givingCoupon() {
    }

    @Test
    public void getVipCardList() {
    }

    @Test
    public void addVipCardVariety() {
    }

    @Test
    public void deleteVipVariety() {
    }

    @Test
    public void varyVipVariety() {
    }

    private void assertOK(ResponseEntity<?> response) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}