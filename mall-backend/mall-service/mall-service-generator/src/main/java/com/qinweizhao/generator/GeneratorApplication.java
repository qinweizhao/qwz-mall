package com.qinweizhao.generator;

import com.qinweizhao.common.security.annotation.EnableCustomConfig;
import com.qinweizhao.common.security.annotation.EnableRyFeignClients;
import com.qinweizhao.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 代码生成
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class GeneratorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GeneratorApplication.class, args);
        System.out.println("代码生成服务启动");
    }
}
