package com.qf.service;

import com.qf.pojo.resp.BaseResp;

/**
 * Created by lenovo on 2021/1/5.
 */
public interface SearchService {

    BaseResp searchKey(String key, Integer page, Integer size);

}
