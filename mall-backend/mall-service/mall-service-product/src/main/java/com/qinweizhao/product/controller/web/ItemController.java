package com.qinweizhao.product.controller.web;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.vo.SkuItemVO;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@RestController
@RequestMapping("/ua")
public class ItemController {

    @Resource
    private IPmsSkuInfoService pmsSkuInfoService;


    @GetMapping("/{skuId}")
    public R<?> info(@PathVariable("skuId") Long skuId) {
        SkuItemVO skuItem = pmsSkuInfoService.getItemById(skuId);
        return R.success(skuItem);
    }
}
