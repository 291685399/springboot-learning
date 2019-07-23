package com.wyj.controller;

import com.wyj.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消息发送Controller
 */
@Controller
public class IndexController {

    /**
     * 系统发送消息给指定id的用户
     *
     * @param userId
     * @param message
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("systemSendToUser")
    public String systemSendToUser(String userId, String message) throws Exception {
        if (userId == "" || userId == null) {
            return "发送用户id不能为空";
        }
        if (message == "" || message == null) {
            return "发送信息不能为空";
        }
        new WebSocketServer().systemSendToUser(userId, message);
        return "发送成功！";
    }

    /**
     * 系统发送消息给所有用户
     *
     * @param message
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("systemSendAllUser")
    public String systemSendAllUser(String message) throws Exception {
        if (message == "" || message == null) {
            return "发送信息不能为空";
        }
        new WebSocketServer().systemSendAllUser(message);
        return "发送成功！";
    }

}
