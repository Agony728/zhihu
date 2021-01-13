package com.qf.dao;

import com.qf.pojo.vo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2021/1/8.
 */
@Mapper
public interface UserMapper {

    List<Video> findAllVideo();

    void insertVideo(@Param("userId") Integer userId, @Param("url") String url,@Param("date") String date);

    Video findVideo(@Param("userId") Integer userId);

    void deleteVideo(@Param("id") Integer id);
}
