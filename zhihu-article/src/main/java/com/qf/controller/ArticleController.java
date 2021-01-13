package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.ArticleService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/5.
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UploadUtils uploadUtils;

    //删除文章
    @GetMapping("/deleteById")
    public BaseResp deleteById(@RequestBody Map map) {
        return articleService.deleteById((Integer)map.get("id"));
    }

    //添加收藏
    @PostMapping("/insertEnshrine")
    public BaseResp insertEnshrine(@RequestBody Map map){
        return articleService.insertEnshrine(map);
    }

    //取消收藏
    @PostMapping("/deleteEnshrine")
    public BaseResp deleteEnshrine(@RequestBody Map map){
        return articleService.deleteEnshrine((Integer)map.get("id"));
    }

    //点赞
    @PostMapping("/insertPraise")
    public BaseResp insertPraise(@RequestBody Map map){
        return articleService.insertPraise(map);
    }

    //取消点赞
    @PostMapping("/deletePraise")
    public BaseResp deletePraise(@RequestBody Map map){
        return articleService.deletePraise((Integer)map.get("id"));
    }

    //查看点赞人
    @PostMapping("/lookPraise")
    public BaseResp lookPraise(@RequestBody Map map){
        return articleService.lookPraise(map);
    }

    //上传视频
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public BaseResp upload(@RequestParam("file") MultipartFile multipartFile){
        return uploadUtils.upload(multipartFile);
    }

}
