package com.qinweizhao.generator;

import com.qinweizhao.common.security.config.ApplicationConfig;
import com.qinweizhao.common.security.feign.FeignAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * 代码生成
 * 
 * @author qinweizhao
 */
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
// 指定要扫描的Mapper类的包的路径
@MapperScan("com.qinweizhao.**.mapper")
// 开启线程异步执行
@EnableAsync
// 自动加载类
@EnableFeignClients("com.qinweizhao")
@SpringBootApplication
public class GeneratorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GeneratorApplication.class, args);
        System.out.println("代码生成服务启动");
    }
}
