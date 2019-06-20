package org.seec.muggle.auror.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seec.muggle.auror.exception.ErrorDetail;
import org.seec.muggle.auror.util.RequestWrapper;
import org.seec.muggle.auror.vo.user.briefinfo.BriefInfoVO;
import org.seec.muggle.auror.vo.user.coupon.UserCouponsVO;
import org.seec.muggle.auror.vo.user.login.LoginForm;
import org.seec.muggle.auror.vo.user.mark.MovieMarkVO;
import org.seec.muggle.auror.vo.user.message.MessageVO;
import org.seec.muggle.auror.vo.user.register.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void loginTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("nosolution");
        loginForm.setPassword("123456");

        ResponseEntity res = testRestTemplate.postForEntity("/api/login", new HttpEntity<>(loginForm), String.class);
        assertThat(res.getBody()).isNotNull();

    }

    @Test
    public void duplicatedRegisterTest() {
        RegisterForm form = new RegisterForm();
        form.setUsername("nosolution");
        form.setPassword("111");
        ResponseEntity<ErrorDetail> res = testRestTemplate.postForEntity("/api/register", new HttpEntity<>(form), ErrorDetail.class);
        expectSuccess(res);
        assertThat(res.getBody().getMessage()).isEqualTo("用户名已存在");
    }

    @Test
    public void getUserCouponsTest() {
        ResponseEntity<UserCouponsVO[]> res = testRestTemplate.exchange("/api/user/coupon", HttpMethod.GET, RequestWrapper.withUserToken(null), UserCouponsVO[].class);
        assertThat(res.getBody().length).isEqualTo(1);
        UserCouponsVO vo = res.getBody()[0];
        assertThat(vo.getCouponName()).isEqualTo("期末大酬宾");
        assertThat(vo.getCouponDiscount()).isEqualTo(15);
        assertThat(vo.getCouponThreshold()).isEqualTo(50);
        assertThat(vo.getCouponStartTime()).isEqualTo("2019-06-17");
        assertThat(vo.getCouponEndTime()).isEqualTo("2019-06-30");

    }

    @Test
    public void getBriefInfoTest() {
        ResponseEntity<BriefInfoVO[]> res = testRestTemplate.exchange("/api/user/brief_info", HttpMethod.GET, RequestWrapper.withUserToken(null), BriefInfoVO[].class);
        expectSuccess(res);
        assertThat(res.getBody().length).isGreaterThan(0);

    }

    @Test
    public void getMarkListTest() {
        ResponseEntity<MovieMarkVO[]> res = testRestTemplate.exchange("/api/user/mark", HttpMethod.GET, RequestWrapper.withUserToken(null), MovieMarkVO[].class);
        expectSuccess(res);
        assertThat(res.getBody().length).isEqualTo(2);
        assertThat(res.getBody()[0].getMovieId()).isIn(101L, 107L);
        assertThat(res.getBody()[1].getMovieId()).isIn(101L, 107L);
    }

    @Test
    public void getMemberInfoTest() {
        ResponseEntity<String> res = testRestTemplate.exchange("/api/member/info", HttpMethod.GET, RequestWrapper.withUserToken(null), String.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
        assertThat(res.getBody()).isEqualTo("NOT A MEMBER");
    }

    @Test
    public void getMessageTest() {
        ResponseEntity<MessageVO[]> res = testRestTemplate.exchange("/api/user/message", HttpMethod.GET, RequestWrapper.withUserToken(null), MessageVO[].class);
        expectSuccess(res);
        assertThat(res.getBody().length).isEqualTo(1);
    }


    private void expectSuccess(ResponseEntity<?> response) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}