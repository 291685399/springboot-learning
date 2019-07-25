package com.wyj.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyj
 * @create 2019-03-19 20:40
 */
public class User implements Serializable {

    private String name;
    private String sex;
    private int age;
    private Date birthday;
    private String color;

    public User() {
    }

    public User(String name, String sex, int age, Date birthday, String color) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                '}';
    }
}
