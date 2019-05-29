package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.entity.vo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过Environment读取属性文件
 *
 * @Author wyj
 * @Date 2019/5/29 08:59
 */
@RestController
public class EnvironmentController {

    @Autowired
    private Environment environment;

    @RequestMapping("getEnvironment")
    public ApiResponse getEnvironment() {
        Resource resource = new Resource();
        resource.setName(environment.getProperty("com.wyj.user.name"));
        resource.setWebsite(environment.getProperty("com.wyj.user.website"));
        resource.setLanguage(environment.getProperty("com.wyj.user.language"));
        return ApiResponse.ok(resource);
    }

}
