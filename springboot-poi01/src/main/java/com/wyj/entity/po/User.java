package com.wyj.entity.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private String phone;

}
