package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsSkuInfo;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/sku/info")
public class PmsSkuInfoController extends BaseController {

    @Resource
    private IPmsSkuInfoService pmsSkuInfoService;

    /**
     * 查询sku信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/list")
    public R<List<PmsSkuInfo>> list(PmsSkuInfo pmsSkuInfo) {
        List<PmsSkuInfo> list = pmsSkuInfoService.list(pmsSkuInfo);
        return R.success(list);
    }


    /**
     * 获取sku信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{skuId}")
    public R<PmsSkuInfo> getInfo(@PathVariable("skuId") Long skuId) {
        return R.success(pmsSkuInfoService.getById(skuId));
    }

    /**
     * 新增sku信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "sku信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return R.condition(pmsSkuInfoService.save(pmsSkuInfo));
    }

    /**
     * 修改sku信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "sku信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return R.condition(pmsSkuInfoService.updateById(pmsSkuInfo));
    }

    /**
     * 删除sku信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "sku信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public R<Void> remove(@PathVariable Long[] skuIds) {
        return R.condition(pmsSkuInfoService.removeByIds(skuIds));
    }
}
