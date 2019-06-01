package com.wyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyj.mapper")
public class JasyptApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasyptApplication.class, args);
    }

}
