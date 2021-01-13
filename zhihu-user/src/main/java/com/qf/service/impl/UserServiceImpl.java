package com.qf.service.impl;

import com.qf.dao.UserMapper;
import com.qf.pojo.resp.BaseResp;
import com.qf.pojo.vo.Video;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2021/1/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResp findAllVideo() {
        List<Video> list = userMapper.findAllVideo();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("查询所有视频成功");
        baseResp.setData(list);
        return baseResp;
    }

    @Override
    public BaseResp insertVideo(Map map) {
        Integer userId = (Integer) map.get("userId");
        String url = (String) map.get("url");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        userMapper.insertVideo(userId,url,format);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("视频上传成功");
        baseResp.setCode(200);
        return baseResp;
    }

    @Override
    public BaseResp findVideo(Map map) {
        Integer userId = (Integer) map.get("userId");
        Video video = userMapper.findVideo(userId);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("查询视频成功");
        baseResp.setData(video);
        return baseResp;
    }

    @Override
    public BaseResp deleteVideo(Integer id) {
        userMapper.deleteVideo(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("删除成功");
        return baseResp;
    }

}
