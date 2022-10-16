package com.qinweizhao.product.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sku信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/sku/info")
public class PmsSkuController {

//    @Resource
//    private IPmsSkuService PmsSkuService;
//
//
//    /**
//     * 查询sku信息分页
//     */
//    @RequiresPermissions("product:info:list")
//    @GetMapping("/page")
//    public R<PageResult<PmsSku>> list(PmsSku PmsSku) {
//        List<PmsSku> list = PmsSkuService.list(PmsSku);
//        return getPageResult(list);
//    }
//
//
//    /**
//     * 获取sku信息详细信息
//     */
//    @RequiresPermissions("product:info:query")
//    @GetMapping(value = "/{skuId}")
//    public R<PmsSku> getInfo(@PathVariable("skuId") Long skuId) {
//        return R.success(PmsSkuService.getById(skuId));
//    }
//
//    /**
//     * 新增sku信息
//     */
//    @RequiresPermissions("product:info:add")
//    @Log(title = "sku信息", businessType = BusinessType.INSERT)
//    @PostMapping
//    public R<?> add(@RequestBody PmsSku PmsSku) {
//        return R.success(PmsSkuService.save(PmsSku));
//    }
//
//    /**
//     * 修改sku信息
//     */
//    @RequiresPermissions("product:info:edit")
//    @Log(title = "sku信息", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public R<?> edit(@RequestBody PmsSku PmsSku) {
//        return R.success(PmsSkuService.updateById(PmsSku));
//    }
//
//    /**
//     * 删除sku信息
//     */
//    @RequiresPermissions("product:info:remove")
//    @Log(title = "sku信息", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{skuIds}")
//    public R<?> remove(@PathVariable Long[] skuIds) {
//        return R.success(PmsSkuService.removeBatchByIds(skuIds));
//    }
}
