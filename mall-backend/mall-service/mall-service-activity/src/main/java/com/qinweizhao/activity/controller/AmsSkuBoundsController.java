package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsSkuBounds;
import com.qinweizhao.activity.service.IAmsSkuBoundsService;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品sku积分设置Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/bounds")
public class AmsSkuBoundsController {
    @Resource
    private IAmsSkuBoundsService amsSkuBoundsService;

    /**
     * 查询商品sku积分设置列表
     */
    @RequiresPermissions("activity:bounds:list")
    @GetMapping("/list")
    public R<List<AmsSkuBounds>> list(AmsSkuBounds amsSkuBounds) {

        List<AmsSkuBounds> list = amsSkuBoundsService.selectAmsSkuBoundsList(amsSkuBounds);
        return R.success(list);
    }

    /**
     * 导出商品sku积分设置列表
     */
    @RequiresPermissions("activity:bounds:export")
    @Log(title = "商品sku积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSkuBounds amsSkuBounds) {
        List<AmsSkuBounds> list = amsSkuBoundsService.selectAmsSkuBoundsList(amsSkuBounds);
        ExcelUtil<AmsSkuBounds> util = new ExcelUtil<AmsSkuBounds>(AmsSkuBounds.class);
        util.exportExcel(response, list, "商品sku积分设置数据");
        return R.success();
    }

    /**
     * 获取商品sku积分设置详细信息
     */
    @RequiresPermissions("activity:bounds:query")
    @GetMapping(value = "/{id}")
    public R<AmsSkuBounds> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSkuBoundsService.selectAmsSkuBoundsById(id));
    }

    /**
     * 新增商品sku积分设置
     */
    @RequiresPermissions("activity:bounds:add")
    @Log(title = "商品sku积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSkuBounds amsSkuBounds) {
        return R.success(amsSkuBoundsService.insertAmsSkuBounds(amsSkuBounds));
    }

    /**
     * 修改商品sku积分设置
     */
    @RequiresPermissions("activity:bounds:edit")
    @Log(title = "商品sku积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSkuBounds amsSkuBounds) {
        return R.success(amsSkuBoundsService.updateAmsSkuBounds(amsSkuBounds));
    }

    /**
     * 删除商品sku积分设置
     */
    @RequiresPermissions("activity:bounds:remove")
    @Log(title = "商品sku积分设置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsSkuBoundsService.deleteAmsSkuBoundsByIds(ids));
    }
}
