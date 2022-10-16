package com.qinweizhao.sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author qinweizhao
 * @since 2022/03/12
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.qinweizhao.**.mapper")
@EnableAsync
@EnableFeignClients("com.qinweizhao")
@SpringBootApplication
public class SaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleApplication.class, args);
        System.out.println("营销服务启动成功");
    }

}
