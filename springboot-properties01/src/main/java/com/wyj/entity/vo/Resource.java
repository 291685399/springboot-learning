package com.wyj.entity.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author WYJ
 * @Date 2019/5/27 11:39
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "com.wyj.user")
@PropertySource(value = "classpath:resource.properties")//PropertySource默认取application.properties
public class Resource {

    private String name;
    private String website;
    private String language;

}
