package com.qinweizhao.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.qinweizhao.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SupportApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SupportApplication.class, args);
        System.out.println("服务支持模块启动成功");
    }
}
