package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.entity.PmsSkuAttrValue;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku销售属性&值Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/sku/attr")
public class PmsSkuAttrValueController extends BaseController {

    @Resource
    private IPmsSkuAttrValueService pmsSkuAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public R<List<PmsSkuAttrValue>> list(PmsSkuAttrValue pmsSkuAttrValue) {
        List<PmsSkuAttrValue> list = pmsSkuAttrValueService.list(pmsSkuAttrValue);
        return R.success(list);
    }

    /**
     * 获取sku销售属性&值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public R<PmsSkuAttrValue> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSkuAttrValueService.getById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "sku销售属性&值", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody PmsSkuAttrValue pmsSkuAttrValue) {
        return R.success(pmsSkuAttrValueService.save(pmsSkuAttrValue));
    }

    /**
     * 修改sku销售属性&值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "sku销售属性&值", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsSkuAttrValue pmsSkuAttrValue) {
        return R.success(pmsSkuAttrValueService.updateById(pmsSkuAttrValue));
    }

    /**
     * 删除sku销售属性&值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "sku销售属性&值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(pmsSkuAttrValueService.removeByIds(ids));
    }
}
