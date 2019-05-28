package com.wyj.entity.po;

import java.io.Serializable;

/**
 * @author wyj
 * @create 2019-03-18 23:40
 */
public class User implements Serializable {

    private int id;

    private String username;

    private String sex;

    public User() {
    }

    public User(int id, String username, String sex) {
        this.id = id;
        this.username = username;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
