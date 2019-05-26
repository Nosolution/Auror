package org.seec.muggle.auror;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AurorApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
    }


    /**
     * 只是为了保存token而已
     */
    @Test
    public void something() {
        String token = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJub3NvbHV0aW9uIiwiZXhwIjoxNTU1NjQ0MzU4LCJpYXQiOjE1NTUwMzk1NTh9.KedXgMpdiSRcqcR1GfS0zWh_aayuFMNq-lgj4-vywsjnvC-fC7biinSWlYNKZ4Rc2L6cbJUPefLrmaNA7b1aAw";
    }

    @Test
    public void loginTest() {
        Map<String, String> param = new HashMap<>();
        param.put("username", "1206985125@qq.com");
        param.put("password", "123456789");
        ResponseEntity<Map> response = testRestTemplate.exchange("/login", HttpMethod.POST, new HttpEntity<>(param), Map.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().get("role")).isEqualTo("USER");
    }

    @Test
    public void registerTest() {
        Map<String, String> param = new HashMap<>();
        param.put("username", "1206985125@qq.com");
        param.put("password", "123456789");
        ResponseEntity<Map> response = testRestTemplate.exchange("/register", HttpMethod.POST, new HttpEntity<>(param), Map.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void gerPopularMovieTest() {
        ResponseEntity<Map[]> response = testRestTemplate.getForEntity("/movie/popular", Map[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().length).isGreaterThan(0);
    }

    @Test
    public void getMovieOnShelfTest() {
        ResponseEntity<Map[]> response = testRestTemplate.getForEntity("/movie/onshelf", Map[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().length).isGreaterThan(0);
    }

    @Test
    public void getMovieDetail() {
        ResponseEntity<Map> response = testRestTemplate.getForEntity("/movie/detail/1", Map.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Map<String, Object> body = response.getBody();
        assertThat(body).hasSize(9);
    }

    @Test
    public void markMovieTest() {
        Map<String, String> param = new HashMap<>();
        param.put("userId", "125");
        param.put("movieId", "1");
        ResponseEntity<Map> response = testRestTemplate.exchange("/movie/mark", HttpMethod.POST, new HttpEntity<>(param), Map.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        expectSuccess(response);
        Map<String, String> body = response.getBody();
        assertThat(body).isNull();
    }

    private void expectSuccess(ResponseEntity<?> response) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
