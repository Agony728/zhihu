package com.qf.service;

import com.qf.pojo.resp.BaseResp;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/6.
 */
public interface HelpService {

    BaseResp findAllType();

    BaseResp findByQtid(Integer id);

    BaseResp findAll();

    //BaseResp findByQid(Integer id);

    BaseResp createStaticThymeleaf(Integer id);

    BaseResp findUrl(Map map);

}
