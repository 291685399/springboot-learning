package com.wyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index1")
    public String index1() {
        return "index1";
    }

    @RequestMapping(value = "/index2")
    public String index2() {
        return "index2";
    }

}
