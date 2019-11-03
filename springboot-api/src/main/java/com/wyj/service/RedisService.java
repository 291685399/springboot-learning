package com.wyj.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author wyj
 * @date 2019-10-30 09:57
 */
@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key, int i, int timeout, TimeUnit timeType) {
        redisTemplate.opsForValue().set(key, String.valueOf(i), timeout, timeType);
    }

    public void incr(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    public Integer get(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return Integer.valueOf(value);
    }
}
