package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsSpuInfo;
import com.qinweizhao.product.service.IPmsSpuInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/info")
public class PmsSpuInfoController extends BaseController {
    @Resource
    private IPmsSpuInfoService pmsSpuInfoService;

    /**
     * 查询spu信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/list")
    public R<List<PmsSpuInfo>> list(PmsSpuInfo pmsSpuInfo) {
        startPage();
        List<PmsSpuInfo> list = pmsSpuInfoService.selectPmsSpuInfoList(pmsSpuInfo);
        return R.success(list);
    }

    /**
     * 导出spu信息列表
     */
    @RequiresPermissions("product:info:export")
    @Log(title = "spu信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSpuInfo pmsSpuInfo) {
        List<PmsSpuInfo> list = pmsSpuInfoService.selectPmsSpuInfoList(pmsSpuInfo);
        ExcelUtil<PmsSpuInfo> util = new ExcelUtil<PmsSpuInfo>(PmsSpuInfo.class);
        util.exportExcel(response, list, "spu信息数据");
        return R.success();
    }

    /**
     * 获取spu信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{spuId}")
    public R<PmsSpuInfo> getInfo(@PathVariable("spuId") Long spuId) {
        return R.success(pmsSpuInfoService.selectPmsSpuInfoBySpuId(spuId));
    }

    /**
     * 新增spu信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "spu信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSpuInfo pmsSpuInfo) {
        return R.condition(pmsSpuInfoService.insertPmsSpuInfo(pmsSpuInfo));
    }

    /**
     * 修改spu信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSpuInfo pmsSpuInfo) {
        return R.condition(pmsSpuInfoService.updatePmsSpuInfo(pmsSpuInfo));
    }

    /**
     * 删除spu信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<Void> remove(@PathVariable Long[] spuIds) {
        return R.condition(pmsSpuInfoService.deletePmsSpuInfoBySpuIds(spuIds));
    }
}
