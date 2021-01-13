package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2021/1/5.
 */
@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchService zhiHuSearchService;

    @GetMapping("/searchKey")
    public BaseResp searchKey(@RequestParam("key") String key, @RequestParam("page") Integer page, @RequestParam("size") Integer size){
        return zhiHuSearchService.searchKey(key,page,size);
    }

}
