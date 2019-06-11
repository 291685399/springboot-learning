package com.wyj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 在springboot2.0.0之后，WebMvcConfigurerAdapter已经过时了
 * 使用
 *
 * @author wyj
 * @create 2019-06-01 21:48
 */
// /*/**表示拦截所有请求
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * 在springboot2.0.0之前继承WebMvcConfigurerAdapter类，重写addInterceptors方法
     *
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//         * 拦截器按照顺序执行
//         */
//        registry.addInterceptor(new TwoInterceptor())
//                .addPathPatterns("/two/**")
//                .addPathPatterns("/one/**");
//        registry.addInterceptor(new OneInterceptor())
//                .addPathPatterns("/one/**");
//        super.addInterceptors(registry);
//    }

    /**
     * 在springboot2.0.0之后实现WebMvcConfigurer接口，重写addInterceptors方法
     *
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//         * 拦截器按照顺序执行
//         */
//        registry.addInterceptor(new TwoInterceptor())
//                .addPathPatterns("/two/**")
//                .addPathPatterns("/one/**");
//        registry.addInterceptor(new OneInterceptor())
//                .addPathPatterns("/one/**");
//    }

    /**
     * 在springboot2.0.0之后继承WebMvcConfigurationSupport类，重写addInterceptors方法
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new TwoInterceptor())
                .addPathPatterns("/two/**")
                .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor())
                .addPathPatterns("/one/**");
        super.addInterceptors(registry);
    }

}
