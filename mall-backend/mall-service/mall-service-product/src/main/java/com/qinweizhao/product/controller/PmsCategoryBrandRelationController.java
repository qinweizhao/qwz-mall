package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsCategoryBrandRelation;
import com.qinweizhao.product.service.IPmsCategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分类&品牌关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/relation")
public class PmsCategoryBrandRelationController extends BaseController {
    @Autowired
    private IPmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /**
     * 查询分类&品牌关联列表
     */
    @RequiresPermissions("product:relation:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        startPage();
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationList(pmsCategoryBrandRelation);
        return getDataTable(list);
    }

    /**
     * 导出分类&品牌关联列表
     */
    @RequiresPermissions("product:relation:export")
    @Log(title = "分类&品牌关联" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        List<PmsCategoryBrandRelation> list = pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationList(pmsCategoryBrandRelation);
        ExcelUtil<PmsCategoryBrandRelation> util = new ExcelUtil<PmsCategoryBrandRelation>(PmsCategoryBrandRelation.class);
        util.exportExcel(response, list, "分类&品牌关联数据");
    }

    /**
     * 获取分类&品牌关联详细信息
     */
    @RequiresPermissions("product:relation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pmsCategoryBrandRelationService.selectPmsCategoryBrandRelationById(id));
    }

    /**
     * 新增分类&品牌关联
     */
    @RequiresPermissions("product:relation:add")
    @Log(title = "分类&品牌关联" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return toAjax(pmsCategoryBrandRelationService.insertPmsCategoryBrandRelation(pmsCategoryBrandRelation));
    }

    /**
     * 修改分类&品牌关联
     */
    @RequiresPermissions("product:relation:edit")
    @Log(title = "分类&品牌关联" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return toAjax(pmsCategoryBrandRelationService.updatePmsCategoryBrandRelation(pmsCategoryBrandRelation));
    }

    /**
     * 删除分类&品牌关联
     */
    @RequiresPermissions("product:relation:remove")
    @Log(title = "分类&品牌关联" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pmsCategoryBrandRelationService.deletePmsCategoryBrandRelationByIds(ids));
    }
}
