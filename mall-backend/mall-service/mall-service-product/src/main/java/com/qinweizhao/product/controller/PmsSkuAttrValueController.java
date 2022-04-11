package com.qinweizhao.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.qinweizhao.modle.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSkuAttrValue;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.page.TableDataInfo;

/**
 * sku销售属性&值Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/value")
public class PmsSkuAttrValueController extends BaseController {
    @Resource
    private IPmsSkuAttrValueService pmsSkuAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public R<List<PmsSkuAttrValue>> list(PmsSkuAttrValue pmsSkuAttrValue) {
        startPage();
        List<PmsSkuAttrValue> list = pmsSkuAttrValueService.selectPmsSkuAttrValueList(pmsSkuAttrValue);
        return R.success(list);
    }

    /**
     * 导出sku销售属性&值列表
     */
    @RequiresPermissions("product:value:export")
    @Log(title = "sku销售属性&值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSkuAttrValue pmsSkuAttrValue) {
        List<PmsSkuAttrValue> list = pmsSkuAttrValueService.selectPmsSkuAttrValueList(pmsSkuAttrValue);
        ExcelUtil<PmsSkuAttrValue> util = new ExcelUtil<PmsSkuAttrValue>(PmsSkuAttrValue.class);
        util.exportExcel(response, list, "sku销售属性&值数据");
        return R.success();
    }

    /**
     * 获取sku销售属性&值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public R<PmsSkuAttrValue> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSkuAttrValueService.selectPmsSkuAttrValueById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "sku销售属性&值", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSkuAttrValue pmsSkuAttrValue) {
        return R.condition(pmsSkuAttrValueService.insertPmsSkuAttrValue(pmsSkuAttrValue));
    }

    /**
     * 修改sku销售属性&值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "sku销售属性&值", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSkuAttrValue pmsSkuAttrValue) {
        return R.condition(pmsSkuAttrValueService.updatePmsSkuAttrValue(pmsSkuAttrValue));
    }

    /**
     * 删除sku销售属性&值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "sku销售属性&值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsSkuAttrValueService.deletePmsSkuAttrValueByIds(ids));
    }
}
