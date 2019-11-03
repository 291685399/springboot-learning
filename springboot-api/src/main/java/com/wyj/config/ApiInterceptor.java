package com.wyj.config;

import com.wyj.annotation.AccessLimit;
import com.wyj.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author wyj
 * @date 2019-10-30 09:50
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // 获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maximum();
            boolean login = accessLimit.needLogin();
            String key = "user:visits:账户名";
            // 如果需要登录
            if (login) {
                // 获取登录的session进行判断
                // .....
            }

            // 从redis中获取用户访问的次数
            Integer count = redisService.get(key);
            if (count == null) {
                // 第一次访问
                redisService.set(key, 1, seconds, TimeUnit.SECONDS);
            } else if (count < maxCount) {
                // 加1
                redisService.incr(key);
            } else {
                // 超出访问次数
                render(response, "超出访问次数");
                return false;
            }
        }

        return true;
    }

    private void render(HttpServletResponse response, String msg) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(msg.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
