package com.wyj.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyj
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个单数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中一个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError：发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数
 * @create 2019-06-11 20:40
 */
@RestController
public class DemoController {

    @ApiOperation("测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String demo(String name, String password) {
        return "hhh";
    }

    @ApiOperation("测试接口2")
    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demo2() {
        return "bbb";
    }

}
