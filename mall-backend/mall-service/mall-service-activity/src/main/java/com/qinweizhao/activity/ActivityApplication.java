package com.qinweizhao.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author qinweizhao
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.qinweizhao.**.mapper")
@EnableAsync
@EnableFeignClients("com.qinweizhao")
@SpringBootApplication
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
        System.out.println("营销服务启动成功");
    }

}
