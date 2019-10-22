package com.springcloudservice.servicememeber.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by disvenk.dai on 2018-09-11 17:06
 */

@Getter
@Setter
//@Data
//@NoArgsConstructor
public class UserForm {
    @NotNull(message = "id不能为空")
    @NotBlank(message = "id不能为空")
    public String id;

    @NotNull(message = "姓名不能为空")
    @NotEmpty(message = "姓名不能为空")
    public String name;

}
