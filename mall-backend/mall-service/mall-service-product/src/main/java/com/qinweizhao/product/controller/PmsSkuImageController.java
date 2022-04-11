package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.PmsSkuImage;
import com.qinweizhao.product.service.IPmsSkuImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * sku图片Controller
 *
 * @author qinweizhao
 * @date 2022-04-12
 */
@RestController
@RequestMapping("/image")
public class PmsSkuImageController extends BaseController {
    @Resource
    private IPmsSkuImageService pmsSkuImageService;

    /**
     * 查询sku图片列表
     */
    @RequiresPermissions("product:image:list")
    @GetMapping("/list")
    public R<List<PmsSkuImage>> list(PmsSkuImage pmsSkuImage) {
        startPage();
        List<PmsSkuImage> list = pmsSkuImageService.selectPmsSkuImageList(pmsSkuImage);
        return R.success(list);
    }

    /**
     * 导出sku图片列表
     */
    @RequiresPermissions("product:image:export")
    @Log(title = "sku图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSkuImage pmsSkuImage) {
        List<PmsSkuImage> list = pmsSkuImageService.selectPmsSkuImageList(pmsSkuImage);
        ExcelUtil<PmsSkuImage> util = new ExcelUtil<PmsSkuImage>(PmsSkuImage.class);
        util.exportExcel(response, list, "sku图片数据");
        return R.success();
    }

    /**
     * 获取sku图片详细信息
     */
    @RequiresPermissions("product:image:query")
    @GetMapping(value = "/{skuId}")
    public R<PmsSkuImage> getInfo(@PathVariable("skuId") Long skuId) {
        return R.success(pmsSkuImageService.selectPmsSkuImageBySkuId(skuId));
    }

    /**
     * 新增sku图片
     */
    @RequiresPermissions("product:image:add")
    @Log(title = "sku图片", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSkuImage pmsSkuImage) {
        return R.condition(pmsSkuImageService.insertPmsSkuImage(pmsSkuImage));
    }

    /**
     * 修改sku图片
     */
    @RequiresPermissions("product:image:edit")
    @Log(title = "sku图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSkuImage pmsSkuImage) {
        return R.condition(pmsSkuImageService.updatePmsSkuImage(pmsSkuImage));
    }

    /**
     * 删除sku图片
     */
    @RequiresPermissions("product:image:remove")
    @Log(title = "sku图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public R<Void> remove(@PathVariable Long[] skuIds) {
        return R.condition(pmsSkuImageService.deletePmsSkuImageBySkuIds(skuIds));
    }
}
