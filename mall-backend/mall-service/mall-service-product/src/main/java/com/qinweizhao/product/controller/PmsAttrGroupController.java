package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsAttrGroup;
import com.qinweizhao.product.entity.vo.PmsAttrGroupWithPmsAttrsVO;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 属性分组Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/attr-group")
public class PmsAttrGroupController extends BaseController {

    @Resource
    private IPmsAttrGroupService pmsAttrGroupService;


    /**
     * 查询属性分组列表
     */
    @RequiresPermissions("product:group:list")
    @GetMapping("/page")
    public R<PageResult<PmsAttrGroup>> list(PmsAttrGroup pmsAttrGroup) {
        startPage();
        List<PmsAttrGroup> list = pmsAttrGroupService.list(pmsAttrGroup);
        return getPageResult(list);
    }

    /**
     * 获取属性分组详细信息
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{attrGroupId}")
    public R<PmsAttrGroup> get(@PathVariable("attrGroupId") Long attrGroupId) {
        return R.success(pmsAttrGroupService.getById(attrGroupId));
    }

    /**
     * 新增属性分组
     */
    @RequiresPermissions("product:group:add")
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.condition(pmsAttrGroupService.save(pmsAttrGroup));
    }

    /**
     * 修改属性分组
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.condition(pmsAttrGroupService.updateById(pmsAttrGroup));
    }

    /**
     * 删除属性分组
     */
    @RequiresPermissions("product:group:remove")
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrGroupIds}")
    public R<Void> remove(@PathVariable Long[] attrGroupIds) {
        return R.condition(pmsAttrGroupService.removeByIds(attrGroupIds));
    }


    /**
     * 通过分类 id 获取分属性组和组中属性
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{categoryId}/attr")
    public R<List<PmsAttrGroupWithPmsAttrsVO>> getAttrGroupWithAttrs(@PathVariable("categoryId") Long categoryId) {
        return R.success(pmsAttrGroupService.getPmsAttrGroupWithPmsAttrsByCatelogId(categoryId));
    }


}
