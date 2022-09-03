package com.qinweizhao.activity.controller.app;

import com.qinweizhao.activity.service.IAmsHomeAdvertService;
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

    private final IAmsHomeAdvertService amsHomeAdvertService;

//    @GetMapping("/advert")
//    public R<List<HomeAdvertVO>> list() {
//        List<AmsHomeAdvert> list = amsHomeAdvertService.list();
//        return R.success(HomeAdvertConvert.INSTANCE.convertToVO(list));
//    }


}
