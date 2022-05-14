package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.model.entity.PmsBrand;
import com.qinweizhao.product.service.IPmsBrandService;
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
public class PmsBrandController extends BaseController {

    @Resource
    private IPmsBrandService pmsBrandService;

    /**
     * 分页
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/page")
    public R<PageResult<PmsBrand>> page(PmsBrand pmsBrand) {
        startPage();
        List<PmsBrand> list = pmsBrandService.list(pmsBrand);
        return getPageResult(list);
    }


    /**
     * 详情
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public R<PmsBrand> get(@PathVariable("brandId") Long brandId) {
        return R.success(pmsBrandService.getById(brandId));
    }

    /**
     * 新增
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> save(@RequestBody PmsBrand pmsBrand) {
        return R.condition(pmsBrandService.save(pmsBrand));
    }

    /**
     * 修改
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsBrand pmsBrand) {
        return R.condition(pmsBrandService.updateById(pmsBrand));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public R<Void> remove(@PathVariable Long[] brandIds) {
        return R.condition(pmsBrandService.deleteByIds(brandIds));
    }
}
