package com.qinweizhao.activity.controller.app;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
import com.qinweizhao.component.core.response.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author qinweizhao
 * @since 2022/7/4
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/adverts")
public class HomeController {

    private final IAmsHomeAdvertService amsHomeAdvertService;

    @GetMapping
    public R<List<AmsHomeAdvert>> list() {
        List<AmsHomeAdvert> list = amsHomeAdvertService.list();
        return R.success(list);
    }
}
