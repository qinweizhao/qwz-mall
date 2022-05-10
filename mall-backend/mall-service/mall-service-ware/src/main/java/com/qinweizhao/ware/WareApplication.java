package com.qinweizhao.ware;

import com.qinweizhao.common.security.config.ApplicationConfig;
import com.qinweizhao.common.security.feign.FeignAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author weizhao
 */

@MapperScan("com.qinweizhao.**.mapper")
@EnableAsync
@EnableFeignClients("com.qinweizhao")
@SpringBootApplication
public class WareApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }

}
