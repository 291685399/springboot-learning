package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wyj.mapper")
public class SpringbootTkmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTkmybatisApplication.class, args);
    }

}
