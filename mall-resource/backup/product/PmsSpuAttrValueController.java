package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.entity.PmsSpuAttrValue;
import com.qinweizhao.product.service.IPmsSpuAttrValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu属性值Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/spu/attr/value")
public class PmsSpuAttrValueController extends BaseController {
    @Resource
    private IPmsSpuAttrValueService pmsSpuAttrValueService;

    /**
     * 查询spu属性值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public R<List<PmsSpuAttrValue>> list(PmsSpuAttrValue pmsSpuAttrValue) {
        List<PmsSpuAttrValue> list = pmsSpuAttrValueService.list(pmsSpuAttrValue);
        return R.success(list);
    }

    /**
     * 获取spu属性值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public R<PmsSpuAttrValue> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSpuAttrValueService.getById(id));
    }

    /**
     * 新增spu属性值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "spu属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody PmsSpuAttrValue pmsSpuAttrValue) {
        return R.success(pmsSpuAttrValueService.save(pmsSpuAttrValue));
    }

    /**
     * 修改spu属性值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "spu属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsSpuAttrValue pmsSpuAttrValue) {
        return R.success(pmsSpuAttrValueService.updateById(pmsSpuAttrValue));
    }

    /**
     * 删除spu属性值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "spu属性值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(pmsSpuAttrValueService.removeByIds(ids));
    }
}
