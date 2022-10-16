package com.qinweizhao.search.controller;

import com.qinweizhao.api.product.feign.TestFeignClient;
import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.component.core.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2022/9/2
 */
@RestController
public class Test {

    @Resource
    private TestFeignClient testFeignClient;


    /**
     * 商品上架
     */
    @GetMapping("/app/test")
    public R<?> saveSku() {
        Object testDTO = testFeignClient.getMemberInfo(SecurityConstants.INNER);
        System.out.println(testDTO);
        return R.success(testDTO);
    }

}
