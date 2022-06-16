package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.entity.PmsSpuInfo;
import com.qinweizhao.product.model.param.SpuSaveParam;
import com.qinweizhao.product.service.IPmsSpuInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/spu/info")
public class PmsSpuInfoController extends BaseController {

    @Resource
    private IPmsSpuInfoService pmsSpuInfoService;

    /**
     * 查询spu信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/page")
    public R<PageResult<PmsSpuInfo>> list(PmsSpuInfo pmsSpuInfo) {
        startPage();
        List<PmsSpuInfo> list = pmsSpuInfoService.list(pmsSpuInfo);
        return getPageResult(list);
    }


    /**
     * 获取spu信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{spuId}")
    public R<PmsSpuInfo> getInfo(@PathVariable("spuId") Long spuId) {
        return R.success(pmsSpuInfoService.getById(spuId));
    }

    /**
     * 新增spu信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "spu信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody SpuSaveParam spuSaveParam) {
        return R.success(pmsSpuInfoService.saveSpu(spuSaveParam));
    }

    /**
     * 修改spu状态
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @PutMapping("/status/{spuId}")
    public R<?> updateSpuStatus(@PathVariable Long spuId) {
        return R.success(pmsSpuInfoService.updateSpuStatus(spuId));
    }

    /**
     * 修改spu信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "spu信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsSpuInfo pmsSpuInfo) {
        return R.success(pmsSpuInfoService.updateById(pmsSpuInfo));
    }

    /**
     * 删除spu信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<?> remove(@PathVariable Long[] spuIds) {
        return R.success(pmsSpuInfoService.removeByIds(spuIds));
    }
}
