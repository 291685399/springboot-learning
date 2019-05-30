package com.wyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    public String devtoolsTest() {
        String str = "aaa";
        return str;
    }

}
