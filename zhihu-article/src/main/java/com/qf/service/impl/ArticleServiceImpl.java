package com.qf.service.impl;

import com.qf.dao.ArticleMapper;
import com.qf.pojo.resp.BaseResp;
import com.qf.pojo.vo.EnshrineState;
import com.qf.pojo.vo.PointPraise;
import com.qf.pojo.vo.State;
import com.qf.service.ArticleService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lenovo on 2021/1/5.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public BaseResp insertEnshrine(Map map) {
        BaseResp baseResp = new BaseResp();
        Integer userId = (Integer) map.get("userId");
        Integer stateId = (Integer) map.get("stateId");
        Integer status = (Integer) map.get("status");
        //查看该用户是否收藏这篇文章
        EnshrineState enshrineState = articleMapper.Enshrine(userId,stateId,status);
        if (enshrineState!=null){
            baseResp.setCode(201);
            baseResp.setMsg("已收藏");
            return baseResp;
        }
        int i = articleMapper.insertEnshrine(userId,stateId,status);
        baseResp.setCode(200);
        baseResp.setMsg("添加收藏成功");
        return baseResp;
    }

    @Override
    public BaseResp deleteEnshrine(Integer id) {
        articleMapper.deleteEnshrine(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("取消收藏成功");
        baseResp.setCode(200);
        return baseResp;
    }

    @Override
    public BaseResp insertPraise(Map map) {
        BaseResp baseResp = new BaseResp();
        Integer userId = (Integer)map.get("userId");
        Integer stateId = (Integer)map.get("stateId");
        Integer praise = (Integer)map.get("praise");
        //查看该用户是否收藏这篇文章
        EnshrineState enshrineState = articleMapper.Praise(userId,stateId,praise);
        if (enshrineState!=null){
            baseResp.setCode(201);
            baseResp.setMsg("已点赞");
            return baseResp;
        }
        int i = articleMapper.insertPraise(userId,stateId,praise);
        baseResp.setCode(200);
        baseResp.setMsg("点赞成功");
        return baseResp;
    }

    @Override
    public BaseResp deletePraise(Integer id) {
        articleMapper.deletePraise(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("取消点赞");
        baseResp.setCode(200);
        return baseResp;
    }

    @Override
    public BaseResp lookPraise(Map map) {
        Integer stateId = (Integer)map.get("stateId");
        List<PointPraise> list = articleMapper.lookPraise(stateId);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("查询点赞成功");
        baseResp.setData(list);
        return baseResp;
    }

    @Override
    public BaseResp deleteById(Integer id) {
        articleMapper.deleteById(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("删除成功");
        baseResp.setCode(200);
        return baseResp;
    }

}
