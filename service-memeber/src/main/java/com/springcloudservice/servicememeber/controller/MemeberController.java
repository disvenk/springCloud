package com.springcloudservice.servicememeber.controller;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.sun.javafx.collections.MappingChange;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;


@Validated
@RestController
@Api(value = "会员处理", description = "会员处理控制器")
@EnableSwagger2Doc
@RequestMapping("sss")
public class MemeberController {

    //如果不指定请求方式，就会展示7种请求接口api
    @ApiOperation(value = "获取会员信息",notes = "获取会员详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grade", paramType = "query", value = "名字",defaultValue = "0",required = true, dataType = "Long"),
            @ApiImplicitParam(name = "classroom", paramType = "query", value = "年龄",defaultValue = "0",required = true, dataType = "Long")
    })
    @GetMapping("memeberApi")
    public Map<String, Object> memeberApi(
                                         @NotNull(message = "年级不能为空")
                                         @Range(min = 1, max = 9, message = "年级只能从1-9")
                                                       Integer grade,
                                         @NotNull(message = "班级不能为空")
                                         @Range(min = 1, max = 10, message = "班级只能从1-9")
                                                       Integer classroom
                                        ) {
        System.out.println(grade+"---"+classroom);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","200" );
        return result;
    }

    //传送application/json格式的参数
    @ApiOperation(value = "测试json入参")
    @ApiResponses({ @ApiResponse(code = 200, message = "ok",response = Result.class),
            @ApiResponse(code = 500, message = "ok",response = Result.class) })
    @ApiImplicitParam(paramType = "body",name = "user", value = "用户详细实体", required = true, dataType = "User")
    @RequestMapping(value = "test1",method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    public Map<String, Object> test1(@RequestBody @Valid User user,BindingResult result){
        System.out.println(user.getUserName()+"---"+user.getPassword());
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("code","200" );
        return results;
    }

    //form表单提交，仅支持post
    @ApiOperation(value = "测试form入参")
    @RequestMapping(params = "form",value = "/findById5", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, Object> test2(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","200" );
        return result;
    }

    //path方式，参数放在path中
    @ApiOperation(value = "测试path入参")
    @ApiImplicitParam(paramType = "path",name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/findById1/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> test3(@PathVariable(required = true) Long id){
        System.out.println(id);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","200" );
        return result;
    }

    //header方式，参数放在header中
    @ApiOperation(value = "测试header入参")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "header", dataType = "Long", name = "id", value = "信息id", required = true) })
    @GetMapping("/test4")
    public Map<String, Object> test4(HttpServletRequest request){
        String idstr = request.getHeader("id");
        System.out.println(idstr);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","200" );
        return result;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid final UserForm userForm,BindingResult result){
        //Map<String,Object> result = new HashMap<String,Object>();
        //result.put("code","200" );
        return "66";
    }
}
