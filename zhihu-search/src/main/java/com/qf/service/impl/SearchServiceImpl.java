package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.pojo.resp.BaseResp;
import com.qf.pojo.resp.ZhiHuResp;
import com.qf.service.SearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2021/1/5.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Value("${es.index}")
    private String index;

    @Override
    public BaseResp searchKey(String key, Integer page, Integer size) {
        BaseResp baseResp = new BaseResp();
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types("doc");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (StringUtils.isEmpty(key)) {
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        } else {
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(key,"sname","sinfo","state_type","uname").field("sname",10));
        }
        //设置高亮字段
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("sname");
        highlightBuilder.field("sinfo");
        highlightBuilder.field("state_type");
        highlightBuilder.field("uname");
        highlightBuilder.preTags("<font style='color:red'>");
        highlightBuilder.postTags("</font>");
        searchSourceBuilder.highlighter(highlightBuilder);
        //设置分页
        int from = (page-1)*size;
        searchSourceBuilder.size(size);
        searchSourceBuilder.from(from);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse search = restHighLevelClient.search(searchRequest);
            SearchHits hits = search.getHits();
            System.out.println(hits);
            long totalHits = hits.getTotalHits();
            baseResp.setTotal(totalHits);
            SearchHit[] hits1 = hits.getHits();
            System.out.println(hits1);
            List list = new ArrayList<>();
            for (SearchHit documentFields : hits1) {
                Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();
                String sname = null;
                String sinfo = null;
                String state_type = null;
                String uname = null;
                if (highlightFields!=null){
                    HighlightField sName = highlightFields.get("sname");
                    HighlightField sInfo = highlightFields.get("sinfo");
                    HighlightField stateType = highlightFields.get("state_type");
                    HighlightField uName = highlightFields.get("uname");
                    if (sName!=null){
                        Text[] fragments = sName.getFragments();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (fragments!=null){
                            for (Text fragment : fragments) {
                                sname = stringBuffer.append(fragment).toString();
                            }
                        }
                    }
                    if (sInfo!=null){
                        Text[] fragments = sInfo.getFragments();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (fragments!=null){
                            for (Text fragment : fragments) {
                                sinfo = stringBuffer.append(fragment).toString();
                            }
                        }
                    }
                    if (stateType!=null){
                        Text[] fragments = stateType.getFragments();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (fragments!=null){
                            for (Text fragment : fragments) {
                                state_type = stringBuffer.append(fragment).toString();
                            }
                        }
                    }
                    if (uName!=null){
                        Text[] fragments = uName.getFragments();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (fragments!=null){
                            for (Text fragment : fragments) {
                                uname = stringBuffer.append(fragment).toString();
                            }
                        }
                    }
                }
                Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
                if (sname!=null){
                    sourceAsMap.put("sname",sname);
                }
                if (sinfo!=null){
                    sourceAsMap.put("sinfo",sinfo);
                }
                if (state_type!=null){
                    sourceAsMap.put("state_type",state_type);
                }
                if (uname!=null){
                    sourceAsMap.put("uname",uname);
                }
                ZhiHuResp zhiHuResp = JSONObject.parseObject(JSONObject.toJSON(sourceAsMap).toString(), ZhiHuResp.class);
                list.add(zhiHuResp);
            }
            System.out.println(list);
            baseResp.setCode(200);
            baseResp.setMsg("查询成功");
            baseResp.setData(list);
            return baseResp;
        } catch (IOException e) {
            e.printStackTrace();
            baseResp.setCode(301);
            baseResp.setMsg("查询失败");
            return baseResp;
        }
    }

}
