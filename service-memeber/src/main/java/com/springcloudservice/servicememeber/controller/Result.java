package com.springcloudservice.servicememeber.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by disvenk.dai on 2018-12-27 11:22
 */
@Data
public class Result {

    @ApiModelProperty(example="200")
    private String code;

    @ApiModelProperty(example="请求成功")
    private String massage;
}
