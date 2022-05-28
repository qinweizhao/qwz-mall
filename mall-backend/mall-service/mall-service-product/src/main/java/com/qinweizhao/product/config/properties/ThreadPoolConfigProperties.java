package com.qinweizhao.product.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author weizhao
 */
@Data
@ConfigurationProperties(prefix = "mall.thread")
public class ThreadPoolConfigProperties {
    private Integer coreSize = 20;
    private Integer maxSize = 200;
    private Integer keepAliveTime = 10;
}
