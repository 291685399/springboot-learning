package com.wyj.entity.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String phone;

}
