package com.wyj.controller;

import com.wyj.annotation.AccessLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyj
 * @date 2019-10-30 09:51
 */
@RestController
public class DemoController {

    @AccessLimit(seconds = 5, maximum = 5, needLogin = true)
    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
    public String test() {
        return "请求成功";
    }
}