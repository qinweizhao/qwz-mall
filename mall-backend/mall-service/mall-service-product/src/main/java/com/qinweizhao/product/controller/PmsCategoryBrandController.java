package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.modle.result.R;
import com.qinweizhao.product.domain.PmsCategoryBrand;
import com.qinweizhao.product.service.IPmsCategoryBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分类&品牌关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/brand")
public class PmsCategoryBrandController extends BaseController {
    @Resource
    private IPmsCategoryBrandService pmsCategoryBrandService;

    /**
     * 查询分类&品牌关联列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsCategoryBrand pmsCategoryBrand) {
        startPage();
        List<PmsCategoryBrand> list = pmsCategoryBrandService.selectPmsCategoryBrandList(pmsCategoryBrand);
        return getDataTable(list);
    }

    /**
     * 导出分类&品牌关联列表
     */
    @RequiresPermissions("product:brand:export")
    @Log(title = "分类&品牌关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsCategoryBrand pmsCategoryBrand) {
        List<PmsCategoryBrand> list = pmsCategoryBrandService.selectPmsCategoryBrandList(pmsCategoryBrand);
        ExcelUtil<PmsCategoryBrand> util = new ExcelUtil<PmsCategoryBrand>(PmsCategoryBrand.class);
        util.exportExcel(response, list, "分类&品牌关联数据");
        return R.success();
    }

    /**
     * 获取分类&品牌关联详细信息
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{id}")
    public R<PmsCategoryBrand> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsCategoryBrandService.selectPmsCategoryBrandById(id));
    }

    /**
     * 新增分类&品牌关联
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "分类&品牌关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsCategoryBrand pmsCategoryBrand) {
        return R.condition(pmsCategoryBrandService.insertPmsCategoryBrand(pmsCategoryBrand));
    }

    /**
     * 修改分类&品牌关联
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "分类&品牌关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsCategoryBrand pmsCategoryBrand) {
        return R.condition(pmsCategoryBrandService.updatePmsCategoryBrand(pmsCategoryBrand));
    }

    /**
     * 删除分类&品牌关联
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "分类&品牌关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsCategoryBrandService.deletePmsCategoryBrandByIds(ids));
    }
}
