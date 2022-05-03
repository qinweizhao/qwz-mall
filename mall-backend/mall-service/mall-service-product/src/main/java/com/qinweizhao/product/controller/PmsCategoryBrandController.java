package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsCategoryBrand;
import com.qinweizhao.product.service.IPmsBrandService;
import com.qinweizhao.product.service.IPmsCategoryBrandService;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类&品牌关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-24
 */
@RestController
@RequestMapping("/category/brand")
public class PmsCategoryBrandController extends BaseController {

    @Resource
    private IPmsCategoryBrandService pmsCategoryBrandService;

    @Resource
    private IPmsCategoryService pmsCategoryService;

    @Resource
    private IPmsBrandService pmsBrandService;

    /**
     * 列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public R<List<PmsCategoryBrand>> list(PmsCategoryBrand pmsCategoryBrand) {
        List<PmsCategoryBrand> list = pmsCategoryBrandService.list(pmsCategoryBrand);
        return R.success(list);
    }

    /**
     * 新增
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "分类&品牌关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsCategoryBrand pmsCategoryBrand) {
        pmsCategoryBrand.setCategoryName(pmsCategoryService.getById(pmsCategoryBrand.getCategoryId()).getName());
        pmsCategoryBrand.setBrandName(pmsBrandService.getById(pmsCategoryBrand.getBrandId()).getName());
        return R.condition(pmsCategoryBrandService.save(pmsCategoryBrand));
    }

    /**
     * 删除分类&品牌关联
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "分类&品牌关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsCategoryBrandService.removeByIds(ids));
    }

}
