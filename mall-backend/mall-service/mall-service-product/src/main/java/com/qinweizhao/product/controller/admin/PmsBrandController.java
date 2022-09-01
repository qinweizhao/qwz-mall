package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.model.dto.BrandDTO;
import com.qinweizhao.product.model.entity.PmsBrand;
import com.qinweizhao.product.model.params.BrandParam;
import com.qinweizhao.product.service.PmsBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController  {

    @Resource
    private PmsBrandService pmsBrandService;

    /**
     * 分页
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/page")
    public R<PageResult<BrandDTO>> page(BrandParam param) {
        PageResult<BrandDTO> result = pmsBrandService.page(param);
        return R.success(result);
    }


    /**
     * 详情
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public R<BrandDTO> get(@PathVariable("brandId") Long brandId) {
        return R.success(pmsBrandService.getById(brandId));
    }

    /**
     * 新增
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Boolean> save(@RequestBody PmsBrand pmsBrand) {
        return R.success(pmsBrandService.save(pmsBrand));
    }

    /**
     * 修改
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Boolean> edit(@RequestBody PmsBrand pmsBrand) {
        return R.success(pmsBrandService.updateById(pmsBrand));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public R<Boolean> remove(@PathVariable List<Long> brandIds) {
        return R.success(pmsBrandService.removeBatchByIds(brandIds));
    }
}
