package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.entity.vo.ApiResponse;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wyj
 * @create 2019-03-17 22:28
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertUser")
    public ApiResponse insertUser() {
        User user = new User("1", "admin", "admin");
        userService.insertUser(user);
        return ApiResponse.success("保存成功");
    }

    @RequestMapping(value = "/updateUser")
    public ApiResponse updateUser() {
        User user = new User();
        user.setId("1");
        user.setPassword("abc");
        userService.updateUser(user);
        return ApiResponse.success("修改成功");
    }

    @RequestMapping(value = "/deleteUser")
    public ApiResponse deleteUser() {
        String id = "1";
        userService.deleteUser(id);
        return ApiResponse.success("删除成功");
    }

    @RequestMapping(value = "/seleteUser")
    public ApiResponse seleteUser() {
        String id = "1";
        User user = userService.seleteUser(id);
        return ApiResponse.success(user);
    }

    @RequestMapping(value = "/seleteUserList")
    public ApiResponse seleteUserList() {
        User user = new User();
        user.setUsername("admin");
        List<User> users = userService.seleteUserList(user);
        return ApiResponse.success(users);
    }

}
