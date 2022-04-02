package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsProductAttrValue;
import com.qinweizhao.product.service.IPmsProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu属性值Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/attr/value")
public class PmsProductAttrValueController extends BaseController {
    @Autowired
    private IPmsProductAttrValueService pmsProductAttrValueService;

    /**
     * 查询spu属性值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsProductAttrValue pmsProductAttrValue) {
        startPage();
        List<PmsProductAttrValue> list = pmsProductAttrValueService.selectPmsProductAttrValueList(pmsProductAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出spu属性值列表
     */
    @RequiresPermissions("product:value:export")
    @Log(title = "spu属性值" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsProductAttrValue pmsProductAttrValue) {
        List<PmsProductAttrValue> list = pmsProductAttrValueService.selectPmsProductAttrValueList(pmsProductAttrValue);
        ExcelUtil<PmsProductAttrValue> util = new ExcelUtil<PmsProductAttrValue>(PmsProductAttrValue.class);
        util.exportExcel(response, list, "spu属性值数据");
    }

    /**
     * 获取spu属性值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pmsProductAttrValueService.selectPmsProductAttrValueById(id));
    }

    /**
     * 新增spu属性值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "spu属性值" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsProductAttrValue pmsProductAttrValue) {
        return toAjax(pmsProductAttrValueService.insertPmsProductAttrValue(pmsProductAttrValue));
    }

    /**
     * 修改spu属性值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "spu属性值" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsProductAttrValue pmsProductAttrValue) {
        return toAjax(pmsProductAttrValueService.updatePmsProductAttrValue(pmsProductAttrValue));
    }

    /**
     * 删除spu属性值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "spu属性值" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pmsProductAttrValueService.deletePmsProductAttrValueByIds(ids));
    }
}
