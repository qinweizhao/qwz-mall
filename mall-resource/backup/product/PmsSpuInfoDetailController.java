package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.model.entity.PmsSpuInfoDetail;
import com.qinweizhao.product.service.IPmsSpuInfoDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息介绍Controller
 *
 * @author qinweizhao
 * @date 2022-05-02
 */
@RestController
@RequestMapping("/detail")
public class PmsSpuInfoDetailController extends BaseController {

    @Resource
    private IPmsSpuInfoDetailService pmsSpuInfoDetailService;

    /**
     * 查询spu信息介绍列表
     */
    @RequiresPermissions("product:detail:list")
    @GetMapping("/list")
    public R<List<PmsSpuInfoDetail>> list(PmsSpuInfoDetail pmsSpuInfoDetail) {
        startPage();
        List<PmsSpuInfoDetail> list = pmsSpuInfoDetailService.list(pmsSpuInfoDetail);
        return R.success(list);
    }


    /**
     * 获取spu信息介绍详细信息
     */
    @RequiresPermissions("product:detail:query")
    @GetMapping(value = "/{spuId}")
    public R<PmsSpuInfoDetail> getInfo(@PathVariable("spuId") Long spuId) {
        return R.success(pmsSpuInfoDetailService.getById(spuId));
    }

    /**
     * 新增spu信息介绍
     */
    @RequiresPermissions("product:detail:add")
    @Log(title = "spu信息介绍", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSpuInfoDetail pmsSpuInfoDetail) {
        return R.condition(pmsSpuInfoDetailService.save(pmsSpuInfoDetail));
    }

    /**
     * 修改spu信息介绍
     */
    @RequiresPermissions("product:detail:edit")
    @Log(title = "spu信息介绍", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSpuInfoDetail pmsSpuInfoDetail) {
        return R.condition(pmsSpuInfoDetailService.updateById(pmsSpuInfoDetail));
    }

    /**
     * 删除spu信息介绍
     */
    @RequiresPermissions("product:detail:remove")
    @Log(title = "spu信息介绍", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<Void> remove(@PathVariable Long[] spuIds) {
        return R.condition(pmsSpuInfoDetailService.removeByIds(spuIds));
    }
}
