package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.mapper.LoggerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoggerController {

    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @Autowired
    private LoggerMapper loggerMapper;

    @RequestMapping("/logger")
    public String showLogger() {
        // 级别由低到高 trace<debug<info<warn<error
        logger.trace("这是一个trace日志");
        logger.debug("这是一个debug日志");
        logger.info("这是一个info日志");
        logger.warn("这是一个warn日志");
        logger.error("这是一个error日志");

        List<User> userList = loggerMapper.findAll();
        System.out.println(userList);

        return userList.toString();
    }

}
