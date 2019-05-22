package com.wyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.wyj.mapper"})
public class MybatisPlus02Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus02Application.class, args);
    }

}
