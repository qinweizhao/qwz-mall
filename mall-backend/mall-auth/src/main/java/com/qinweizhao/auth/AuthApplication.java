package com.qinweizhao.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证授权中心
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@EnableFeignClients("com.qinweizhao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        System.out.println("认证授权中心启动成功");
    }
}
