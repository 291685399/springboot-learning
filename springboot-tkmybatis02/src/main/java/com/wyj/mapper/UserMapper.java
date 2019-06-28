package com.wyj.mapper;

import com.wyj.entity.po.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User selectUserById(int id);

    public List<User> selectUserList();

}
