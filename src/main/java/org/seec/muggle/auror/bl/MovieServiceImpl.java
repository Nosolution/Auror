package org.seec.muggle.auror.bl;


import org.seec.muggle.auror.dao.FavoriteRecordMapper;
import org.seec.muggle.auror.dao.MovieMapper;
import org.seec.muggle.auror.param.DateLikeForm;
import org.seec.muggle.auror.param.MovieForm;
import org.seec.muggle.auror.po.FavoriteRecord;
import org.seec.muggle.auror.po.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo 不清楚会报什么错
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final String ALREADY_LIKE_ERROR_MESSAGE = "用户已标记该电影为想看";
    private static final String UNLIKE_ERROR_MESSAGE = "用户未标记该电影为想看";
    private static final String USER_NOT_EXIST_ERROR_MESSAGE = "用户不存在";
    private static final String MOVIE_NOT_EXIST_ERROR_MESSAGE = "电影不存在";

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private FavoriteRecordMapper favoriteRecordMapper;

    /**
     * todo 需要细化exception
     */
    @Override
    public boolean addMovie(MovieForm addMovieForm) {
        try {
            movieMapper.insertOneMovie(addMovieForm);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * todo 返回值可能有Null 需在上层检测
     */
    @Override
    public Movie searchOneMovieByIdAndUserId(int id, int userId) {
        try {
            return movieMapper.selectMovieByIdAndUserId(id, userId);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<Movie> searchAllMovie() {
        try {
            return movieMapper.selectAllMovie();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String likeMovie(int userId, int movieId) {
        FavoriteRecord record = new FavoriteRecord();
        record.setUserId(userId);
        record.setMovieId(movieId);
        //todo: user 判空
        if (userLikeTheMovie(userId, movieId)) {
            return ALREADY_LIKE_ERROR_MESSAGE;
        } else if (movieMapper.selectMovieById(movieId) == null) {
            return MOVIE_NOT_EXIST_ERROR_MESSAGE;
        }
        try {
            //todo 待考证这些方法成功时的返回值
            if ((favoriteRecordMapper.insert(record)) == 1) {
                return "Success";
            } else {
                return "Failure";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String unLikeMovie(int userId, int movieId) {
        if (!userLikeTheMovie(userId, movieId)) {
            return UNLIKE_ERROR_MESSAGE;
        } else if (movieMapper.selectMovieById(movieId) == null) {
            return MOVIE_NOT_EXIST_ERROR_MESSAGE;
        }
        try {
            //todo 同上
            if (favoriteRecordMapper.delete(movieId, userId) == 1) {
                return "Success";
            }
            return "Failure";
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public int getCountOfLikes(int movieId) {
        try {
            return favoriteRecordMapper.selectFavoriteNums(movieId);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Movie> getMovieByKeyword(String keyword) {
        //todo 需要上层验证是否为空
        if (keyword == null || keyword.equals(""))
            return movieMapper.selectAllMovie();
        return movieMapper.selectMovieByKeyword(keyword);
    }

    @Override
    public List<DateLikeForm> getLikeNumsGroupByDate(int movieId) {
        //todo movieId为假的情况未考虑
        try {
            return favoriteRecordMapper.getDateLikeNum(movieId);
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean userLikeTheMovie(int userId, int movieId) {
        return favoriteRecordMapper.selectLikeMovie(movieId, userId) == 0 ? false : true;
    }


}
