package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findAll")
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        return userList;
    }

}
