package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSpuImages;
import com.qinweizhao.product.service.IPmsSpuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu图片Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/images")
public class PmsSpuImagesController extends BaseController {
    @Autowired
    private IPmsSpuImagesService pmsSpuImagesService;

    /**
     * 查询spu图片列表
     */
    @RequiresPermissions("product:images:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSpuImages pmsSpuImages) {
        startPage();
        List<PmsSpuImages> list = pmsSpuImagesService.selectPmsSpuImagesList(pmsSpuImages);
        return getDataTable(list);
    }

    /**
     * 导出spu图片列表
     */
    @RequiresPermissions("product:images:export")
    @Log(title = "spu图片" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSpuImages pmsSpuImages) {
        List<PmsSpuImages> list = pmsSpuImagesService.selectPmsSpuImagesList(pmsSpuImages);
        ExcelUtil<PmsSpuImages> util = new ExcelUtil<PmsSpuImages>(PmsSpuImages.class);
        util.exportExcel(response, list, "spu图片数据");
    }

    /**
     * 获取spu图片详细信息
     */
    @RequiresPermissions("product:images:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pmsSpuImagesService.selectPmsSpuImagesById(id));
    }

    /**
     * 新增spu图片
     */
    @RequiresPermissions("product:images:add")
    @Log(title = "spu图片" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSpuImages pmsSpuImages) {
        return toAjax(pmsSpuImagesService.insertPmsSpuImages(pmsSpuImages));
    }

    /**
     * 修改spu图片
     */
    @RequiresPermissions("product:images:edit")
    @Log(title = "spu图片" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSpuImages pmsSpuImages) {
        return toAjax(pmsSpuImagesService.updatePmsSpuImages(pmsSpuImages));
    }

    /**
     * 删除spu图片
     */
    @RequiresPermissions("product:images:remove")
    @Log(title = "spu图片" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pmsSpuImagesService.deletePmsSpuImagesByIds(ids));
    }
}
