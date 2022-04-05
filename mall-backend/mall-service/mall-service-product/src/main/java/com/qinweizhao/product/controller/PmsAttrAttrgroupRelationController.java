package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsAttrAttrgroupRelation;
import com.qinweizhao.product.service.IPmsAttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 属性&属性分组关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("attr/group/relation")
public class PmsAttrAttrgroupRelationController extends BaseController {

    @Autowired
    private IPmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    /**
     * 查询属性&属性分组关联列表
     */
    @RequiresPermissions("product:relation:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        startPage();
        List<PmsAttrAttrgroupRelation> list = pmsAttrAttrgroupRelationService.selectPmsAttrAttrgroupRelationList(pmsAttrAttrgroupRelation);
        return getDataTable(list);
    }

    /**
     * 导出属性&属性分组关联列表
     */
    @RequiresPermissions("product:relation:export")
    @Log(title = "属性&属性分组关联" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        List<PmsAttrAttrgroupRelation> list = pmsAttrAttrgroupRelationService.selectPmsAttrAttrgroupRelationList(pmsAttrAttrgroupRelation);
        ExcelUtil<PmsAttrAttrgroupRelation> util = new ExcelUtil<PmsAttrAttrgroupRelation>(PmsAttrAttrgroupRelation.class);
        util.exportExcel(response, list, "属性&属性分组关联数据");
    }

    /**
     * 获取属性&属性分组关联详细信息
     */
    @RequiresPermissions("product:relation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pmsAttrAttrgroupRelationService.selectPmsAttrAttrgroupRelationById(id));
    }

    /**
     * 新增属性&属性分组关联
     */
    @RequiresPermissions("product:relation:add")
    @Log(title = "属性&属性分组关联" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return toAjax(pmsAttrAttrgroupRelationService.insertPmsAttrAttrgroupRelation(pmsAttrAttrgroupRelation));
    }

    /**
     * 修改属性&属性分组关联
     */
    @RequiresPermissions("product:relation:edit")
    @Log(title = "属性&属性分组关联" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return toAjax(pmsAttrAttrgroupRelationService.updatePmsAttrAttrgroupRelation(pmsAttrAttrgroupRelation));
    }

    /**
     * 删除属性&属性分组关联
     */
    @RequiresPermissions("product:relation:remove")
    @Log(title = "属性&属性分组关联" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pmsAttrAttrgroupRelationService.deletePmsAttrAttrgroupRelationByIds(ids));
    }
}
