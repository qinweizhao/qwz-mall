package com.qinweizhao.system;

import com.qinweizhao.common.security.annotation.EnableCustomConfig;
import com.qinweizhao.common.security.annotation.EnableRyFeignClients;
import com.qinweizhao.common.swagger.annotation.EnableCustomSwagger2;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 系统模块
 *
 * @author qinweizhao
 * @since 2021-12-22
 */
@EnableAdminServer
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class MallSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallSystemApplication.class, args);
        System.out.println("系统模块启动成功");
    }
}
