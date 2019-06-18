package com.wyj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wyj
 * @create 2019-06-11 20:34
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wyj.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")//接口文档主题
                .description("API网关接口：http://www.baidu.com")//地址
                .termsOfServiceUrl("www.taobao.com")//路径
                .version("1.0.0")//版本号
                .build();
    }
}
