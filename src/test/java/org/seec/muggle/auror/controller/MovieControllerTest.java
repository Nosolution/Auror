package org.seec.muggle.auror.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getMovieDetail() {
    }

    @Test
    public void getPopularMovie() {
    }

    @Test
    public void getMovieOnShelf() {
    }

    @Test
    public void markMovie() {
    }

    @Test
    public void commentMovie() {
    }

    @Test
    public void getMovieComment() {
    }

    @Test
    public void addMovie() {
    }

    @Test
    public void varyMovie() {
    }

    @Test
    public void deleteMovie() {
    }

    @Test
    public void getFavorNum() {
    }

    @Test
    public void getAttendance() {
    }

    @Test
    public void getBoxOffice() {
    }

    @Test
    public void getMoviesByList() {
    }
}