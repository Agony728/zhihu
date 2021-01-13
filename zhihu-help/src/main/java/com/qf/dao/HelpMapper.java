package com.qf.dao;

import com.qf.pojo.vo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2021/1/6.
 */
@Mapper
public interface HelpMapper {

    List<Question> findAllType();

    List<Question> findByQtid(@Param("qtid") Integer id);

    List<Question> findAll();

    //Question findByQid(@Param("qid") Integer id);

    Question findById(@Param("qid")Integer id);

    void updateById(Question question);

    String findUrl(@Param("qid")Integer id);

}
