package com.qinweizhao.auth;

import com.qinweizhao.component.redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AuthApplicationTests {

    @Resource
    RedisService redisService;

    @Test
    void contextLoads() {
        Object cacheObject = redisService.hasKey("login_tokens:f4bf5de1-a833-483b-a416-2593d4c7e3d6");
        System.out.println(cacheObject.toString());
    }

}
