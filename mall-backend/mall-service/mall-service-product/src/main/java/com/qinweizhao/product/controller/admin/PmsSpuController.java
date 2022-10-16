package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.convert.SpuConvert;
import com.qinweizhao.product.model.dto.SpuDTO;
import com.qinweizhao.product.model.entity.PmsSpu;
import com.qinweizhao.product.model.param.SpuSaveParam;
import com.qinweizhao.product.model.params.SpuParam;
import com.qinweizhao.product.service.PmsSpuService;
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
public class PmsSpuController {

    @Resource
    private PmsSpuService pmsSpuInfoService;

    /**
     * 查询spu信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/page")
    public PageResult<SpuDTO> list(SpuParam param) {
        return pmsSpuInfoService.page(param);
    }

    /**
     * 获取spu信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{spuId}")
    public R<SpuDTO> getInfo(@PathVariable("spuId") Long spuId) {
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
     * 修改spu状态（上架下架）
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
    public R<Boolean> edit(@RequestBody SpuParam param) {
        PmsSpu pmsSpu = SpuConvert.INSTANCE.convert(param);
        return R.success(pmsSpuInfoService.updateById(pmsSpu));
    }

    /**
     * 删除spu信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "spu信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{spuIds}")
    public R<Boolean> remove(@PathVariable List<Long> spuIds) {
        return R.success(pmsSpuInfoService.removeBatchByIds(spuIds));
    }
}
