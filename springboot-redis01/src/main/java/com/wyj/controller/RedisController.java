package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.entity.vo.ApiResponse;
import com.wyj.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/test")
    public ApiResponse test() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("abc");
        redisTemplate.opsForValue().set("json", JsonUtils.objectToJson(user));
        User jsonUser = JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("json"), User.class);
        redisTemplate.opsForValue().set("aaa", "哈哈哈");
        return ApiResponse.ok(redisTemplate.opsForValue().get("aaa"));
    }

}
