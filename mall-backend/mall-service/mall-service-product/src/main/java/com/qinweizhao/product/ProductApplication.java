package com.qinweizhao.product;

import com.qinweizhao.common.security.annotation.EnableCustomConfig;
import com.qinweizhao.common.security.annotation.EnableRyFeignClients;
import com.qinweizhao.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
