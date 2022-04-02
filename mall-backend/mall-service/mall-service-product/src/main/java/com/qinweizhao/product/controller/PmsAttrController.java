package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsAttr;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品属性Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/attr")
public class PmsAttrController extends BaseController {
    @Autowired
    private IPmsAttrService pmsAttrService;

    /**
     * 查询商品属性列表
     */
    @RequiresPermissions("product:attr:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsAttr pmsAttr) {
        startPage();
        List<PmsAttr> list = pmsAttrService.selectPmsAttrList(pmsAttr);
        return getDataTable(list);
    }

    /**
     * 导出商品属性列表
     */
    @RequiresPermissions("product:attr:export")
    @Log(title = "商品属性" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsAttr pmsAttr) {
        List<PmsAttr> list = pmsAttrService.selectPmsAttrList(pmsAttr);
        ExcelUtil<PmsAttr> util = new ExcelUtil<PmsAttr>(PmsAttr.class);
        util.exportExcel(response, list, "商品属性数据");
    }

    /**
     * 获取商品属性详细信息
     */
    @RequiresPermissions("product:attr:query")
    @GetMapping(value = "/{attrId}")
    public AjaxResult getInfo(@PathVariable("attrId") Long attrId) {
        return AjaxResult.success(pmsAttrService.selectPmsAttrByAttrId(attrId));
    }

    /**
     * 新增商品属性
     */
    @RequiresPermissions("product:attr:add")
    @Log(title = "商品属性" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsAttr pmsAttr) {
        return toAjax(pmsAttrService.insertPmsAttr(pmsAttr));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsAttr pmsAttr) {
        return toAjax(pmsAttrService.updatePmsAttr(pmsAttr));
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "商品属性" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrIds}")
    public AjaxResult remove(@PathVariable Long[] attrIds) {
        return toAjax(pmsAttrService.deletePmsAttrByAttrIds(attrIds));
    }
}
