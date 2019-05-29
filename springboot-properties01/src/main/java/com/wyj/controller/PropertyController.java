package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.entity.vo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取ConfigurationProperties属性文件
 *
 * @Author wyj
 * @Date 2019/5/27 11:41
 */
@RestController
public class PropertyController {

    @Autowired
    private Resource resource;

    @RequestMapping("/getResource")
    public ApiResponse getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return ApiResponse.ok(bean);
    }

}
