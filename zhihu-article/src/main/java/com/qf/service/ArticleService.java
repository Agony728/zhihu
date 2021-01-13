package com.qf.service;

import com.qf.pojo.resp.BaseResp;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/5.
 */
public interface ArticleService {

    BaseResp deleteById(Integer id);

    BaseResp insertEnshrine(Map map);

    BaseResp deleteEnshrine(Integer id);

    BaseResp insertPraise(Map map);

    BaseResp deletePraise(Integer id);

    BaseResp lookPraise(Map map);
}
