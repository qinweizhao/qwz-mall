package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSpuInfoDesc;
import com.qinweizhao.product.service.IPmsSpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu信息介绍Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/desc")
public class PmsSpuInfoDescController extends BaseController {

    @Autowired
    private IPmsSpuInfoDescService pmsSpuInfoDescService;

    /**
     * 查询spu信息介绍列表
     */
    @RequiresPermissions("product:desc:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSpuInfoDesc pmsSpuInfoDesc) {
        startPage();
        List<PmsSpuInfoDesc> list = pmsSpuInfoDescService.selectPmsSpuInfoDescList(pmsSpuInfoDesc);
        return getDataTable(list);
    }

    /**
     * 导出spu信息介绍列表
     */
    @RequiresPermissions("product:desc:export")
    @Log(title = "spu信息介绍" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSpuInfoDesc pmsSpuInfoDesc) {
        List<PmsSpuInfoDesc> list = pmsSpuInfoDescService.selectPmsSpuInfoDescList(pmsSpuInfoDesc);
        ExcelUtil<PmsSpuInfoDesc> util = new ExcelUtil<PmsSpuInfoDesc>(PmsSpuInfoDesc.class);
        util.exportExcel(response, list, "spu信息介绍数据");
    }

    /**
     * 获取spu信息介绍详细信息
     */
    @RequiresPermissions("product:desc:query")
    @GetMapping(value = "/{spuId}")
    public AjaxResult getInfo(@PathVariable("spuId") Long spuId) {
        return AjaxResult.success(pmsSpuInfoDescService.selectPmsSpuInfoDescBySpuId(spuId));
    }

    /**
     * 新增spu信息介绍
     */
    @RequiresPermissions("product:desc:add")
    @Log(title = "spu信息介绍" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSpuInfoDesc pmsSpuInfoDesc) {
        return toAjax(pmsSpuInfoDescService.insertPmsSpuInfoDesc(pmsSpuInfoDesc));
    }

    /**
     * 修改spu信息介绍
     */
    @RequiresPermissions("product:desc:edit")
    @Log(title = "spu信息介绍" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSpuInfoDesc pmsSpuInfoDesc) {
        return toAjax(pmsSpuInfoDescService.updatePmsSpuInfoDesc(pmsSpuInfoDesc));
    }

    /**
     * 删除spu信息介绍
     */
    @RequiresPermissions("product:desc:remove")
    @Log(title = "spu信息介绍" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public AjaxResult remove(@PathVariable Long[] spuIds) {
        return toAjax(pmsSpuInfoDescService.deletePmsSpuInfoDescBySpuIds(spuIds));
    }
}
