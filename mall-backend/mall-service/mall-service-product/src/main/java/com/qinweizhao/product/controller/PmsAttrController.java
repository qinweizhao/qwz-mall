package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsAttr;
import com.qinweizhao.product.entity.vo.PmsAttrVO;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品属性Controller
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
@RestController
@RequestMapping("/attr")
public class PmsAttrController extends BaseController {

    @Resource
    private IPmsAttrService pmsAttrService;

    /**
     * 查询商品属性列表
     */
    @RequiresPermissions("product:attr:list")
    @GetMapping("/page")
    public R<PageResult<PmsAttr>> page(PmsAttr pmsAttr) {
        startPage();
        List<PmsAttr> list = pmsAttrService.list(pmsAttr);
        return getPageResult(list);
    }

    /**
     * 获取商品属性详细信息
     */
    @RequiresPermissions("product:attr:query")
    @GetMapping(value = "/{attrId}")
    public R<PmsAttr> getInfo(@PathVariable("attrId") Long attrId) {
        return R.success(pmsAttrService.getById(attrId));
    }

    /**
     * 新增商品属性
     */
    @RequiresPermissions("product:attr:add")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsAttrVO pmsAttr) {
        return R.condition(pmsAttrService.save(pmsAttr));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsAttrVO pmsAttr) {
        return R.condition(pmsAttrService.updateById(pmsAttr));
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrIds}")
    public R<Void> remove(@PathVariable Long[] attrIds) {
        return R.condition(pmsAttrService.removeByIds(attrIds));
    }
}
