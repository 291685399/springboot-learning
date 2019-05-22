package com.wyj.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.wyj.entity.po.User;
import com.wyj.mapper.UserMapper;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyj
 * @create 2019-03-17 22:41
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
//        userMapper.insert(user);
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
//        userMapper.updateById(user);
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
//        userMapper.deleteById(id);
        userMapper.deleteUser(id);
    }

    @Override
    public User selectUser(String id) {
//        return (User) userMapper.selectById(id);
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> selectUserList(User user) {
//        return userMapper.selectList(new QueryWrapper<>(user));
        return userMapper.selectUserList(user);
    }

}
