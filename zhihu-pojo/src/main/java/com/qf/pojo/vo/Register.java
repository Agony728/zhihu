package com.qf.pojo.vo;

//注册的实体类

import lombok.Data;

@Data
public class Register {
    private Integer id;
    private String email;
    private String username;
    private String password;
}
