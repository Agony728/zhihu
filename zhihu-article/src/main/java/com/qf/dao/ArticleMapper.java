package com.qf.dao;

import com.qf.pojo.vo.EnshrineState;
import com.qf.pojo.vo.PointPraise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2021/1/5.
 */
@Mapper
public interface ArticleMapper {

    void deleteById(@Param("id") Integer id);

    EnshrineState Enshrine(@Param("userId") Integer userId, @Param("stateId") Integer stateId, @Param("status") Integer status);

    int insertEnshrine(@Param("userId") Integer userId,@Param("stateId") Integer stateId,@Param("status") Integer status);

    void deleteEnshrine(@Param("id") Integer id);

    EnshrineState Praise(@Param("userId") Integer userId, @Param("stateId") Integer stateId, @Param("praise") Integer praise);

    int insertPraise(@Param("userId") Integer userId,@Param("stateId") Integer stateId,@Param("praise") Integer praise);

    void deletePraise(@Param("id") Integer id);

    List<PointPraise> lookPraise(@Param("stateId") Integer stateId);

}
