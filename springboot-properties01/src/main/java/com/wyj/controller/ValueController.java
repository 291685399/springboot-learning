package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.entity.vo.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过Value读取属性文件
 *
 * @Author wyj
 * @Date 2019/5/29 08:50
 */
@RestController
public class ValueController {

    @Value("${com.wyj.user.name}")
    private String name;
    @Value("${com.wyj.user.website}")
    private String website;
    @Value("${com.wyj.user.language}")
    private String language;

    @RequestMapping("/getValue")
    public ApiResponse getValue() {
        Resource resource = new Resource();
        resource.setName(name);
        resource.setWebsite(website);
        resource.setLanguage(language);
        return ApiResponse.ok(resource);
    }

}
