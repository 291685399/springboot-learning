package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable int id) {
        User user = userService.findById(id);
        return user;
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        return userList;
    }

    @RequestMapping("/insert")
    public void insert() {
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(18);
        user.setAddress("江西省");
        user.setPhone("456789645");
        userService.insert(user);
    }

    @RequestMapping("/delete")
    public void delete() {
        User user = new User();
        user.setId(5);
        userService.delete(user);
    }

    @RequestMapping("/update")
    public void update() {
        User user = new User();
        user.setId(5);
        user.setName("李四");
        userService.update(user);
    }

}
