package com.qinweizhao.product.controller.admin;

 import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.entity.PmsAttrAttrGroup;
import com.qinweizhao.product.model.param.AttrAttrGroupSaveBatchParam;
import com.qinweizhao.product.service.IPmsAttrAttrGroupService;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
            PmsAttr attr = pmsAttrService.getById(attrId);
            attr.setAttrId(item.getId());
            return attr;
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
        List<PmsAttr> list = pmsAttrAttrGroupService.listUnRelationByAttrGroupId(attrGroupId);
        return getPageResult(list);
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
     * 修改属性&属性分组关联
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsAttrAttrGroup pmsAttrAttrGroup) {
        return R.success(pmsAttrAttrGroupService.updatePmsAttrAttrGroup(pmsAttrAttrGroup));
    }

    /**
     * 删除关联属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrIds}")
    public R<?> remove(@PathVariable Long[] attrIds) {
        return R.success(pmsAttrAttrGroupService.deletePmsAttrAttrGroupByIds(attrIds));
    }

    /**
     * 批量选择关联属性
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性&属性分组关联", businessType = BusinessType.GRANT)
    @PostMapping
    public R<?> selectAuthUserAll(@RequestBody AttrAttrGroupSaveBatchParam attrAttrGroupSaveBatchParam) {
        return R.success(pmsAttrAttrGroupService.insertPmsAttrAttrGroups(attrAttrGroupSaveBatchParam));
    }
}
