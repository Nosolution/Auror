package org.seec.muggle.auror;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

}
