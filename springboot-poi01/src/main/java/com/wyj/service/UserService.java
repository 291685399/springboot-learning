package com.wyj.service;

import com.wyj.entity.po.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     */
    public List<User> findAll();

    /**
     * 批量插入数据
     *
     * @param userList
     */
    public void insertUserList(List<User> userList);
}
