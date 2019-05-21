package com.wyj.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyj.entity.po.Message;
import com.wyj.mapper.DemoMapper;
import com.wyj.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service(timeout = 6000)
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Message> findMessage() {
        return demoMapper.findMessage();
    }

}
