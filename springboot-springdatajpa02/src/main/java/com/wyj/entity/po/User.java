package com.wyj.entity.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String sex;
    private String address;

}
