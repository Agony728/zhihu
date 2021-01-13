package com.qf.pojo.vo;

import lombok.Data;

//点赞表
@Data
public class PointPraise {
    private Integer id;
    private Integer userId;
    private Integer stateId;
    private Integer praise;

    private String uname;
    private String sname;
    private String info;
}
