package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsSpuAttrValue;
import com.qinweizhao.product.service.IPmsSpuAttrValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * spu属性值Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/value")
public class PmsSpuAttrValueController extends BaseController {
    @Resource
    private IPmsSpuAttrValueService pmsSpuAttrValueService;

    /**
     * 查询spu属性值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public R<List<PmsSpuAttrValue>> list(PmsSpuAttrValue pmsSpuAttrValue) {
        startPage();
        List<PmsSpuAttrValue> list = pmsSpuAttrValueService.selectPmsSpuAttrValueList(pmsSpuAttrValue);
        return R.success(list);
    }

    /**
     * 导出spu属性值列表
     */
    @RequiresPermissions("product:value:export")
    @Log(title = "spu属性值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSpuAttrValue pmsSpuAttrValue) {
        List<PmsSpuAttrValue> list = pmsSpuAttrValueService.selectPmsSpuAttrValueList(pmsSpuAttrValue);
        ExcelUtil<PmsSpuAttrValue> util = new ExcelUtil<PmsSpuAttrValue>(PmsSpuAttrValue.class);
        util.exportExcel(response, list, "spu属性值数据");
        return R.success();
    }

    /**
     * 获取spu属性值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public R<PmsSpuAttrValue> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSpuAttrValueService.selectPmsSpuAttrValueById(id));
    }

    /**
     * 新增spu属性值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "spu属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSpuAttrValue pmsSpuAttrValue) {
        return R.condition(pmsSpuAttrValueService.insertPmsSpuAttrValue(pmsSpuAttrValue));
    }

    /**
     * 修改spu属性值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "spu属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSpuAttrValue pmsSpuAttrValue) {
        return R.condition(pmsSpuAttrValueService.updatePmsSpuAttrValue(pmsSpuAttrValue));
    }

    /**
     * 删除spu属性值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "spu属性值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsSpuAttrValueService.deletePmsSpuAttrValueByIds(ids));
    }
}
