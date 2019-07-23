package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.session.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wyj
 * @create 2019-06-01 22:06
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login.html")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(User user) {
        //查询数据库，我这里直接写死
        User dbUser = new User(1, "zhangsan", "123456", "admin");
        if (dbUser.getPassword().equals(user.getPassword())) {
            UserInfo userInfo = new UserInfo(dbUser.getId(), dbUser.getUsername(), dbUser.getRole());
            HttpSession session = getRequest().getSession();
            session.setAttribute("user_info_in_the_session", userInfo);
            return "admin";
        }
        return "login";
    }

    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public String userInfo() {
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user_info_in_the_session");
        return userInfo.toString();
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

}
