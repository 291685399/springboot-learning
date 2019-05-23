package com.wyj.service.impl;

import com.wyj.entity.po.Message;
import com.wyj.mapper.DemoMapper;
import com.wyj.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Message> findMessage() {
        return demoMapper.findMessage();
    }

}
