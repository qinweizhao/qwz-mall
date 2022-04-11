package com.qinweizhao.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.qinweizhao.product.domain.PmsSpuImage;
import com.qinweizhao.product.service.IPmsSpuImageService;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.page.TableDataInfo;

/**
 * spu图片Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/image")
public class PmsSpuImageController extends BaseController {
    @Resource
    private IPmsSpuImageService pmsSpuImageService;

    /**
     * 查询spu图片列表
     */
    @RequiresPermissions("product:image:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSpuImage pmsSpuImage) {
        startPage();
        List<PmsSpuImage> list = pmsSpuImageService.selectPmsSpuImageList(pmsSpuImage);
        return getDataTable(list);
    }

    /**
     * 导出spu图片列表
     */
    @RequiresPermissions("product:image:export")
    @Log(title = "spu图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSpuImage pmsSpuImage) {
        List<PmsSpuImage> list = pmsSpuImageService.selectPmsSpuImageList(pmsSpuImage);
        ExcelUtil<PmsSpuImage> util = new ExcelUtil<PmsSpuImage>(PmsSpuImage.class);
        util.exportExcel(response, list, "spu图片数据");
        return R.success();
    }

    /**
     * 获取spu图片详细信息
     */
    @RequiresPermissions("product:image:query")
    @GetMapping(value = "/{spuId}")
    public R<PmsSpuImage> getInfo(@PathVariable("spuId") Long spuId) {
        return R.success(pmsSpuImageService.selectPmsSpuImageBySpuId(spuId));
    }

    /**
     * 新增spu图片
     */
    @RequiresPermissions("product:image:add")
    @Log(title = "spu图片", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSpuImage pmsSpuImage) {
        return R.condition(pmsSpuImageService.insertPmsSpuImage(pmsSpuImage));
    }

    /**
     * 修改spu图片
     */
    @RequiresPermissions("product:image:edit")
    @Log(title = "spu图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSpuImage pmsSpuImage) {
        return R.condition(pmsSpuImageService.updatePmsSpuImage(pmsSpuImage));
    }

    /**
     * 删除spu图片
     */
    @RequiresPermissions("product:image:remove")
    @Log(title = "spu图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<Void> remove(@PathVariable Long[] spuIds) {
        return R.condition(pmsSpuImageService.deletePmsSpuImageBySpuIds(spuIds));
    }
}
