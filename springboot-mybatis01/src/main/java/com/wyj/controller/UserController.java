package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.entity.vo.APIResponse;
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
    public APIResponse insertUser() {
        User user = new User("1", "admin", "admin");
        userService.insertUser(user);
        return APIResponse.success("保存成功");
    }

    @RequestMapping(value = "/updateUser")
    public APIResponse updateUser() {
        User user = new User();
        user.setId("1");
        user.setPassword("abc");
        userService.updateUser(user);
        return APIResponse.success("修改成功");
    }

    @RequestMapping(value = "/deleteUser")
    public APIResponse deleteUser() {
        String id = "1";
        userService.deleteUser(id);
        return APIResponse.success("删除成功");
    }

    @RequestMapping(value = "/seleteUser")
    public APIResponse seleteUser() {
        String id = "1";
        User user = userService.seleteUser(id);
        return APIResponse.success(user);
    }

    @RequestMapping(value = "/seleteUserList")
    public APIResponse seleteUserList() {
        User user = new User();
        user.setUsername("admin");
        List<User> users = userService.seleteUserList(user);
        return APIResponse.success(users);
    }

}
