package com.wyj.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wyj
 * @create 2019-07-31 20:09
 */
@Data
public class User implements Serializable {

    private int id;
    private String username;
    private String password;

}
