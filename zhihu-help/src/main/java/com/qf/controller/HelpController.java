package com.qf.controller;

import com.qf.pojo.resp.BaseResp;
import com.qf.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lenovo on 2021/1/5.
 */
@RestController
@RequestMapping("/help")
@CrossOrigin
public class HelpController {

    @Autowired
    private HelpService helpService;

    @GetMapping("/findAllType")
    public BaseResp findAllType(){
        return helpService.findAllType();
    }

    @GetMapping("/findByQtid")
    public BaseResp findByQtid(@RequestParam("id") Integer id){
        return helpService.findByQtid(id);
    }

    @GetMapping("/findAll")
    public BaseResp findAll(){
        return helpService.findAll();
    }

    //@GetMapping("/findByQid")
    //public BaseResp findByQid(@RequestParam("id") Integer id){
    //    return helpService.findByQid(id);
    //}

    @PostMapping("/createStaticThymeleaf")
    public BaseResp createStaticThymeleaf(@RequestBody Map map){
        return helpService.createStaticThymeleaf((Integer)map.get("id"));
    }

    @PostMapping("/findUrl")
    public BaseResp findUrl(@RequestBody Map map){
        System.out.println(map);
        return helpService.findUrl(map);
    }


}
