package com.wyj.controller;

import com.wyj.entity.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wyj
 * @create 2019-03-19 19:46
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setColor("<font color='green'><b>hello thymeleaf</b></font>");

        User user1 = new User();
        user1.setName("张三");
        user1.setSex("男");
        user1.setAge(18);
        user1.setBirthday(new Date());
        user1.setColor("<font color='green'><b>hello thymeleaf</b></font>");
        User user2 = new User();
        user2.setName("王五");
        user2.setSex("女");
        user2.setAge(19);
        user2.setBirthday(new Date());
        user2.setColor("<font color='green'><b>hello thymeleaf</b></font>");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        System.out.println(userList);
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/postform")
    public String postform(User user) {
        System.out.println("name:" + user.getName());
        System.out.println("sex" + user.getSex());
        return "redirect:/index";
    }

}
