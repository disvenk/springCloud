package com.springcloudservice.servicememeber.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by disvenk.dai on 2018-11-26 18:57
 */
@Data
public class User {

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空字符串")
    @ApiModelProperty(value = "用户名",example="用户名")
    String userName;

    @NotNull(message = "密码名不能为空")
    @NotBlank(message = "密码名不能为空字符串")
    @ApiModelProperty(value = "密码",example="123")
    String password;

    @NotNull(message = "年龄不能为空")
    @ApiModelProperty(value = "年龄",example="23",dataType = "java.lang.Integer")
    Integer age;

    @NotNull(message = "用户数组不能为空")
    @ApiModelProperty(value = "用户数组",example="[{'userName':'disvenk'}]")
    List<User> users;
}
