package com.wyj.controller;

import com.wyj.entity.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wyj
 * @create 2019-03-18 23:36
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(5);
        user.setUsername("张三");
        user.setSex("男");
        modelAndView.setViewName("index");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

}
