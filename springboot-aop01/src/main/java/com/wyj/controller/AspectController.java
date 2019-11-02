package com.wyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AspectController {

    @RequestMapping(value = "/aspect")
    @ResponseBody
    public String aspect() {
        System.out.println("执行aspect方法");
//        int a = 1 / 0;
        return "aspect方法返回数据";
    }
}
