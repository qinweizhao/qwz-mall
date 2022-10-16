package com.qinweizhao.sale.controller.app;

import com.qinweizhao.sale.service.SmsHomeAdvertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author qinweizhao
 * @since 2022/7/4
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/home")
public class HomeController {

    private final SmsHomeAdvertService amsHomeAdvertService;



}
