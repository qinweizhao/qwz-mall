package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.entity.PmsSpuImage;
import com.qinweizhao.product.service.IPmsSpuImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu图片Controller
 *
 * @author qinweizhao
 * @date 2022-05-03
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
    public R<List<PmsSpuImage>> list(PmsSpuImage pmsSpuImage) {
        startPage();
        List<PmsSpuImage> list = pmsSpuImageService.selectPmsSpuImageList(pmsSpuImage);
        return R.success(list);
    }

    /**
     * 导出spu图片列表
     */
    @RequiresPermissions("product:image:export")
    @Log(title = "spu图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, PmsSpuImage pmsSpuImage) {
        List<PmsSpuImage> list = pmsSpuImageService.selectPmsSpuImageList(pmsSpuImage);
        ExcelUtil<PmsSpuImage> util = new ExcelUtil<>(PmsSpuImage.class);
        util.exportExcel(response, list, "spu图片数据");
        return R.success();
    }

    /**
     * 获取spu图片详细信息
     */
    @RequiresPermissions("product:image:query")
    @GetMapping(value = "/{id}")
    public R<PmsSpuImage> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSpuImageService.selectPmsSpuImageById(id));
    }

    /**
     * 新增spu图片
     */
    @RequiresPermissions("product:image:add")
    @Log(title = "spu图片", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody PmsSpuImage pmsSpuImage) {
        return R.success(pmsSpuImageService.insertPmsSpuImage(pmsSpuImage));
    }

    /**
     * 修改spu图片
     */
    @RequiresPermissions("product:image:edit")
    @Log(title = "spu图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsSpuImage pmsSpuImage) {
        return R.success(pmsSpuImageService.updatePmsSpuImage(pmsSpuImage));
    }

    /**
     * 删除spu图片
     */
    @RequiresPermissions("product:image:remove")
    @Log(title = "spu图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(pmsSpuImageService.deletePmsSpuImageByIds(ids));
    }
}
