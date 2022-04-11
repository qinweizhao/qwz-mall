package com.qinweizhao.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.qinweizhao.modle.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSkuImages;
import com.qinweizhao.product.service.IPmsSkuImagesService;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.page.TableDataInfo;

/**
 * sku图片Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/images")
public class PmsSkuImagesController extends BaseController {
    @Resource
    private IPmsSkuImagesService pmsSkuImagesService;

    /**
     * 查询sku图片列表
     */
    @RequiresPermissions("product:images:list")
    @GetMapping("/list")
    public R<List<PmsSkuImages>> list(PmsSkuImages pmsSkuImages) {
        startPage();
        List<PmsSkuImages> list = pmsSkuImagesService.selectPmsSkuImagesList(pmsSkuImages);
        return R.success(list);
    }

    /**
     * 导出sku图片列表
     */
    @RequiresPermissions("product:images:export")
    @Log(title = "sku图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSkuImages pmsSkuImages) {
        List<PmsSkuImages> list = pmsSkuImagesService.selectPmsSkuImagesList(pmsSkuImages);
        ExcelUtil<PmsSkuImages> util = new ExcelUtil<PmsSkuImages>(PmsSkuImages.class);
        util.exportExcel(response, list, "sku图片数据");
        return R.success();
    }

    /**
     * 获取sku图片详细信息
     */
    @RequiresPermissions("product:images:query")
    @GetMapping(value = "/{skuId}")
    public R<PmsSkuImages> getInfo(@PathVariable("skuId") Long skuId) {
        return R.success(pmsSkuImagesService.selectPmsSkuImagesBySkuId(skuId));
    }

    /**
     * 新增sku图片
     */
    @RequiresPermissions("product:images:add")
    @Log(title = "sku图片", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSkuImages pmsSkuImages) {
        return R.condition(pmsSkuImagesService.insertPmsSkuImages(pmsSkuImages));
    }

    /**
     * 修改sku图片
     */
    @RequiresPermissions("product:images:edit")
    @Log(title = "sku图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSkuImages pmsSkuImages) {
        return R.condition(pmsSkuImagesService.updatePmsSkuImages(pmsSkuImages));
    }

    /**
     * 删除sku图片
     */
    @RequiresPermissions("product:images:remove")
    @Log(title = "sku图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public R<Void> remove(@PathVariable Long[] skuIds) {
        return R.condition(pmsSkuImagesService.deletePmsSkuImagesBySkuIds(skuIds));
    }
}
