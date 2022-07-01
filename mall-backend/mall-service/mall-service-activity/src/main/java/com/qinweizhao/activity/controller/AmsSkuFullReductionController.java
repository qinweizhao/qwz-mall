package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsSkuFullReduction;
import com.qinweizhao.activity.service.IAmsSkuFullReductionService;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品满减信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/reduction")
public class AmsSkuFullReductionController {
    @Resource
    private IAmsSkuFullReductionService amsSkuFullReductionService;

    /**
     * 查询商品满减信息列表
     */
    @RequiresPermissions("activity:reduction:list")
    @GetMapping("/list")
    public R<List<AmsSkuFullReduction>> list(AmsSkuFullReduction amsSkuFullReduction) {

        List<AmsSkuFullReduction> list = amsSkuFullReductionService.selectAmsSkuFullReductionList(amsSkuFullReduction);
        return R.success(list);
    }

    /**
     * 导出商品满减信息列表
     */
    @RequiresPermissions("activity:reduction:export")
    @Log(title = "商品满减信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSkuFullReduction amsSkuFullReduction) {
        List<AmsSkuFullReduction> list = amsSkuFullReductionService.selectAmsSkuFullReductionList(amsSkuFullReduction);
        ExcelUtil<AmsSkuFullReduction> util = new ExcelUtil<AmsSkuFullReduction>(AmsSkuFullReduction.class);
        util.exportExcel(response, list, "商品满减信息数据");
        return R.success();
    }

    /**
     * 获取商品满减信息详细信息
     */
    @RequiresPermissions("activity:reduction:query")
    @GetMapping(value = "/{id}")
    public R<AmsSkuFullReduction> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSkuFullReductionService.selectAmsSkuFullReductionById(id));
    }

    /**
     * 新增商品满减信息
     */
    @RequiresPermissions("activity:reduction:add")
    @Log(title = "商品满减信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSkuFullReduction amsSkuFullReduction) {
        return R.success(amsSkuFullReductionService.insertAmsSkuFullReduction(amsSkuFullReduction));
    }

    /**
     * 修改商品满减信息
     */
    @RequiresPermissions("activity:reduction:edit")
    @Log(title = "商品满减信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSkuFullReduction amsSkuFullReduction) {
        return R.success(amsSkuFullReductionService.updateAmsSkuFullReduction(amsSkuFullReduction));
    }

    /**
     * 删除商品满减信息
     */
    @RequiresPermissions("activity:reduction:remove")
    @Log(title = "商品满减信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsSkuFullReductionService.deleteAmsSkuFullReductionByIds(ids));
    }
}
