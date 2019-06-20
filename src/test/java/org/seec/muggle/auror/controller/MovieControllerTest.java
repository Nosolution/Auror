package org.seec.muggle.auror.controller;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seec.muggle.auror.exception.ErrorDetail;
import org.seec.muggle.auror.util.RequestWrapper;
import org.seec.muggle.auror.vo.movie.comment.CommentVO;
import org.seec.muggle.auror.vo.movie.detail.MovieDetailsVO;
import org.seec.muggle.auror.vo.movie.popularity.MoviePopularVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getMovieDetail() {
        ResponseEntity<MovieDetailsVO> res = testRestTemplate.getForEntity("/api/movie/detail/101", MovieDetailsVO.class);
        expectSuccess(res);
        MovieDetailsVO vo = res.getBody();
        assertThat(vo).isNotNull();
        assertThat(vo.getMovieName()).isEqualTo("X战警：黑凤凰 Dark Phoenix");
        assertThat(vo.getDescription()).isEqualTo("影片剧情围绕X战警中最受欢迎成员之一的琴·葛蕾展开，讲述她逐渐转化为黑凤凰的故事。在一次危及生命的太空营救行动中，琴被神秘的宇宙力量击中，成为最强大的变种人。此后琴·葛蕾不仅要设法掌控日益增长、极不稳定的力量，更要与自己内心的恶魔抗争，她的失控让整个X战警大家庭分崩离析，也让整个星球陷入毁灭的威胁之中。《X战警：黑凤凰》是迄今为止气氛最紧张、情感最丰富的一部《X战警》电影，是《X战警》系列20年来的集大成之作，大家非常熟悉和热爱的变种人大家庭即将面对最为强大的敌人——而她恰恰还是他们中的一员。");
        assertThat(vo.getVisibleDate()).isEqualTo("2019-06-03");
        assertThat(vo.getCountry()).isEqualTo("美国");
        assertThat(vo.getLanguage()).isEqualTo("英语");
        assertThat(vo.getPosterUrl()).isEqualTo("https://s2.ax1x.com/2019/06/12/VRRI1g.jpg");
        assertThat(vo.getLength()).isEqualTo(114);
        assertThat(vo.getMovieType()).isEqualTo("动作 / 科幻 / 冒险");
        assertThat(vo.getYear()).isEqualTo(2019);
    }

    @Test
    public void getPopularMovie() {
        ResponseEntity<MoviePopularVO[]> res = testRestTemplate.getForEntity("/api/movie/popular", MoviePopularVO[].class);
        expectSuccess(res);
        assertThat(res.getBody().length).isEqualTo(7);
    }

    @Test
    public void getMovieOnShelf() {
    }

    @Test
    public void markMovie() {
        ResponseEntity res = testRestTemplate.postForEntity("/api/movie/popular", RequestWrapper.withUserToken(null), Object.class);
        if (res.getStatusCode().equals(HttpStatus.METHOD_NOT_ALLOWED)) {
            assertThat(res.getBody()).isInstanceOf(ErrorDetail.class);
            assertThat(((ErrorDetail) res.getBody()).getMessage()).isEqualTo("重复标记");
        }
    }

    @Test
    public void commentMovie() {

    }

    @Test
    public void getMovieComment() {
        ResponseEntity<CommentVO[]> res = testRestTemplate.getForEntity("/api/movie/popular", CommentVO[].class);
        expectSuccess(res);
        assertThat(res.getBody().length).isEqualTo(7);
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

    private void expectSuccess(ResponseEntity<?> response) {
        AssertionsForInterfaceTypes.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}