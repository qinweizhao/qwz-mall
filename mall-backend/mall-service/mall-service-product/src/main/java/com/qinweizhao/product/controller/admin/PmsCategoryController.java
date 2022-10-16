package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.model.dto.CategoryDTO;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.service.PmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品三级分类 Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/category")
public class PmsCategoryController  {

    @Resource
    private PmsCategoryService pmsCategoryService;


    /**
     * 详情
     */
    @RequiresPermissions("product:category:query")
    @GetMapping(value = "/{categoryId}")
    public R<CategoryDTO> get(@PathVariable("categoryId") Long categoryId) {
        return R.success(pmsCategoryService.getById(categoryId));
    }

    /**
     * 新增
     */
    @RequiresPermissions("product:category:add")
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Boolean> add(@RequestBody PmsCategory pmsCategory) {
        return R.success(pmsCategoryService.save(pmsCategory));
    }

    /**
     * 修改
     */
    @RequiresPermissions("product:category:edit")
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Boolean> edit(@RequestBody PmsCategory pmsCategory) {
        return R.success(pmsCategoryService.updateById(pmsCategory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:category:remove")
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryIds}")
    public R<Boolean> remove(@PathVariable List<Long> categoryIds) {
        return R.success(pmsCategoryService.removeBatchByIds(categoryIds));
    }
}
