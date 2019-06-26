package com.wyj.service.impl;

import com.wyj.entity.po.User;
import com.wyj.mapper.UserMapper;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public void insert(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(User user) {
        userMapper.deleteByPrimaryKey(user);
    }
}
