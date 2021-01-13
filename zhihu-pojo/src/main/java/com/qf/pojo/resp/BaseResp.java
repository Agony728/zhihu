package com.qf.pojo.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lenovo on 2021/1/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResp {

    private Integer code;

    private String msg;

    private Object data;

    private Long total;

}
