package com.qinweizhao.cart.controller;

import com.qinweizhao.component.core.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinweizhao
 * @since 2022/6/2
 */
@RestController
@RequestMapping("/item")
public class CartController {

    @GetMapping("list")
    public R<?> list(){
        return R.success();
    }
}
