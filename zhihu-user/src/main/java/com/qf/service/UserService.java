package com.qf.service;

import com.qf.pojo.resp.BaseResp;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/8.
 */
public interface UserService {

    BaseResp findAllVideo();

    BaseResp insertVideo(Map map);

    BaseResp findVideo(Map map);

    BaseResp deleteVideo(Integer id);

}
