package com.qinweizhao.product.controller.admin;

 import com.qinweizhao.product.controller.base.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
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
    public R<?> save(@RequestBody PmsBrand pmsBrand) {
        return R.success(pmsBrandService.save(pmsBrand));
    }

    /**
     * 修改
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsBrand pmsBrand) {
        return R.success(pmsBrandService.updateById(pmsBrand));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public R<?> remove(@PathVariable Long[] brandIds) {
        return R.success(pmsBrandService.deleteByIds(brandIds));
    }
}
