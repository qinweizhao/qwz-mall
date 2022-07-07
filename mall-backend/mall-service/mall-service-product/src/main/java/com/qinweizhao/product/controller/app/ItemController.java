package com.qinweizhao.product.controller.app;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.vo.SkuItemVO;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/item")
public class ItemController {

    private final IPmsSkuInfoService pmsSkuInfoService;


    @GetMapping("/{skuId}")
    public R<?> info(@PathVariable("skuId") Long skuId) throws ExecutionException, InterruptedException {
        SkuItemVO skuItem = pmsSkuInfoService.getItemById(skuId);
        return R.success(skuItem);
    }
}
