package org.seec.muggle.auror.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

//    @Test
//    public void loginTest() {
//        UserForm userForm = new UserForm();
//        userForm.setUsername("nosolution");
//        userForm.setPassword("asdfghjkl");
//
//        ResponseEntity res = testRestTemplate.postForEntity("/login", new HttpEntity<>(userForm), String.class);
//        assertThat(res.getBody()).isNotNull();
//
//    }


    /**
     * 分别测试shiro不同过滤器的行为
     */
    @Test
    public void restfulTest1() {
        ResponseEntity res = testRestTemplate.getForEntity("/anon_user/3", String.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void restfulTest2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJub3NvbHV0aW9uIiwiZXhwIjoxNTU1NjQ0MzU4LCJpYXQiOjE1NTUwMzk1NTh9.KedXgMpdiSRcqcR1GfS0zWh_aayuFMNq-lgj4-vywsjnvC-fC7biinSWlYNKZ4Rc2L6cbJUPefLrmaNA7b1aAw");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = testRestTemplate.exchange("/user/3", HttpMethod.GET, request, String.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void restfulTest3() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",
                "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJub3NvbHV0aW9uIiwiZXhwIjoxNTU1NjQ0MzU4LCJpYXQiOjE1NTUwMzk1NTh9.KedXgMpdiSRcqcR1GfS0zWh_aayuFMNq-lgj4-vywsjnvC-fC7biinSWlYNKZ4Rc2L6cbJUPefLrmaNA7b1aAw");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = testRestTemplate.exchange("/hyper_user/3", HttpMethod.GET, request, String.class);
        System.out.println("restful test3: " + res);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}