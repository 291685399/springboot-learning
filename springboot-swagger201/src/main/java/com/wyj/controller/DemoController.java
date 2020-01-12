package com.wyj.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(value = "测试Controller", tags = {"测试Controller访问接口"})
@RestController
public class DemoController {

    @ApiOperation("测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String demo(String name, String password) {
        return "aaa";
    }

    @ApiOperation("测试接口2")
    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demo2(@ApiParam("电影名称") @RequestParam("filmName") String filmName,
                        @ApiParam(value = "分数", allowEmptyValue = true) @RequestParam("score") Short score,
                        @ApiParam("发布时间") @RequestParam(value = "publishTime", required = false) String publishTime,
                        @ApiParam("创建者id") @RequestParam("creatorId") Long creatorId) {
        return "bbb";
    }

    @ApiOperation("测试接口3")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数")})
    @RequestMapping(value = "/demo3", method = RequestMethod.POST)
    public String demo3(@ApiParam("电影名称") @RequestParam("filmName") String filmName,
                        @ApiParam(value = "分数", allowEmptyValue = true) @RequestParam("score") Short score,
                        @ApiParam("发布时间") @RequestParam(value = "publishTime", required = false) String publishTime,
                        @ApiParam("创建者id") @RequestParam("creatorId") Long creatorId) {
        return "ccc";
    }

}
