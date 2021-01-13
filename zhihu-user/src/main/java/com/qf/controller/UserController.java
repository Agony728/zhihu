package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/5.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //查看所有视频
    @PostMapping("/findAllVideo")
    public BaseResp findAllVideo(){
        return userService.findAllVideo();
    }

    //将视频路径存入数据库
    @PostMapping("/insertVideo")
    public BaseResp insertVideo(@RequestBody Map map){
        return userService.insertVideo(map);
    }

    //查看用户所有上传的所有视频
    @PostMapping("/findVideo")
    public BaseResp findVideo(@RequestBody Map map){
        return userService.findVideo(map);
    }

    //删除已上传的视频
    @PostMapping("/deleteVideo")
    public BaseResp deleteVideo(@RequestBody Map map){
        return userService.deleteVideo((Integer)map.get("id"));
    }

}
