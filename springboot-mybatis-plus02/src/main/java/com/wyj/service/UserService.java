package com.wyj.service;

import com.wyj.entity.po.User;

import java.util.List;

/**
 * @author wyj
 * @create 2019-03-17 22:41
 */
public interface UserService {

    /**
     * 新增数据
     *
     * @param user
     */
    public void insertUser(User user);

    /**
     * 修改数据
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除数据
     *
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 查找单条数据
     *
     * @param id
     * @return
     */
    public User selectUser(String id);

    /**
     * 查找多条数据
     *
     * @param user
     * @return
     */
    public List<User> selectUserList(User user);

}
