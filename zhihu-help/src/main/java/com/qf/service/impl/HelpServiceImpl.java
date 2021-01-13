package com.qf.service.impl;

import com.qf.dao.HelpMapper;
import com.qf.pojo.resp.BaseResp;
import com.qf.pojo.vo.Question;
import com.qf.service.HelpService;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lenovo on 2021/1/6.
 */
@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    private HelpMapper helpMapper;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UploadUtils uploadUtils;

    @Override
    public BaseResp findAllType() {
        List<Question> list = helpMapper.findAllType();
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setMsg("查询成功");
        baseResp.setData(list);
        return baseResp;
    }

    @Override
    public BaseResp findByQtid(Integer id) {
        List<Question> list = helpMapper.findByQtid(id);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setData(list);
        baseResp.setMsg("查询成功");
        return baseResp;
    }

    @Override
    public BaseResp findAll() {
        List<Question> list = helpMapper.findAll();
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("查询成功");
        baseResp.setCode(200);
        baseResp.setData(list);
        return baseResp;
    }

    //@Override
    //public BaseResp findByQid(Integer id) {
    //    Question question = helpMapper.findByQid(id);
    //    BaseResp baseResp = new BaseResp();
    //    baseResp.setData(question);
    //    baseResp.setCode(200);
    //    baseResp.setMsg("查询成功");
    //    return baseResp;
    //}

    @Override
    public BaseResp createStaticThymeleaf(Integer id) {
        Context context = new Context();
        Question question = helpMapper.findById(id);
        context.setVariable("help",question);
        String articleTemplates = templateEngine.process("HelpTemplates", context);
        //System.out.println(articleTemplates);
        //UUID uuid = UUID.randomUUID();
        BaseResp baseResp = uploadUtils.uploadString(articleTemplates);
        Object data = baseResp.getData();
        question.setStaticUrl(data.toString());
        helpMapper.updateById(question);
        //String replace = uuid.toString().replace("-", "");
        //try {
        //    FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/zhihu/file/" + replace + ".html"));
        //    fileOutputStream.write(articleTemplates.getBytes("utf-8"));
        //    fileOutputStream.close();
        //    question.setStaticUrl(replace+".html");
        //    helpMapper.updateById(question);
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //} catch (UnsupportedEncodingException e) {
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        return null;
    }

    @Override
    public BaseResp findUrl(Map map){
        String id = helpMapper.findUrl((Integer)map.get("id"));
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(200);
        baseResp.setData(id);
        return baseResp;
    }
}
