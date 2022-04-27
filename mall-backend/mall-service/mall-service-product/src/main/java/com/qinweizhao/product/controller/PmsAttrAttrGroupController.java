package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsAttr;
import com.qinweizhao.product.entity.PmsAttrAttrGroup;
import com.qinweizhao.product.service.IPmsAttrAttrGroupService;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性&属性分组关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-27
 */
@RestController
@RequestMapping("/attr/attr-group")
public class PmsAttrAttrGroupController extends BaseController {


    @Resource
    private IPmsAttrAttrGroupService pmsAttrAttrGroupService;

    @Resource
    private IPmsAttrService pmsAttrService;

    /**
     * 查询属性&属性分组关联列表
     */
    @RequiresPermissions("product:group:list")
    @GetMapping("/list")
    public R<List<PmsAttr>> list(PmsAttrAttrGroup pmsAttrAttrGroup) {
        List<PmsAttrAttrGroup> list = pmsAttrAttrGroupService.selectPmsAttrAttrGroupList(pmsAttrAttrGroup);
        List<PmsAttr> collect = list.stream().map(item -> {
            Long attrId = item.getAttrId();
            return pmsAttrService.selectPmsAttrByAttrId(attrId);
        }).collect(Collectors.toList());
        return R.success(collect);
    }


    /**
     * 查询属性&属性分组关联列表
     */
    @RequiresPermissions("product:group:list")
    @GetMapping("/un-relation")
    public R<PageResult<PmsAttr>> unRelationList(Long attrGroupId) {
        startPage();
        List<PmsAttr> list = pmsAttrAttrGroupService.selectPmsAttrAttrGroupUnRelationList(attrGroupId);
        return getPageResult(list);
    }


    /**
     * 导出属性&属性分组关联列表
     */
    @RequiresPermissions("product:group:export")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsAttrAttrGroup pmsAttrAttrGroup) {
        List<PmsAttrAttrGroup> list = pmsAttrAttrGroupService.selectPmsAttrAttrGroupList(pmsAttrAttrGroup);
        ExcelUtil<PmsAttrAttrGroup> util = new ExcelUtil<PmsAttrAttrGroup>(PmsAttrAttrGroup.class);
        util.exportExcel(response, list, "属性&属性分组关联数据");
        return R.success();
    }

    /**
     * 获取属性&属性分组关联详细信息
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{id}")
    public R<PmsAttrAttrGroup> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsAttrAttrGroupService.selectPmsAttrAttrGroupById(id));
    }

    /**
     * 新增属性&属性分组关联
     */
    @RequiresPermissions("product:group:add")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsAttrAttrGroup pmsAttrAttrGroup) {
        return R.condition(pmsAttrAttrGroupService.insertPmsAttrAttrGroup(pmsAttrAttrGroup));
    }

    /**
     * 修改属性&属性分组关联
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsAttrAttrGroup pmsAttrAttrGroup) {
        return R.condition(pmsAttrAttrGroupService.updatePmsAttrAttrGroup(pmsAttrAttrGroup));
    }

    /**
     * 删除属性&属性分组关联
     */
    @RequiresPermissions("product:group:remove")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsAttrAttrGroupService.deletePmsAttrAttrGroupByIds(ids));
    }
}
