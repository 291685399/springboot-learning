package com.wyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wyj
 * @create 2019-03-19 19:46
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

}
