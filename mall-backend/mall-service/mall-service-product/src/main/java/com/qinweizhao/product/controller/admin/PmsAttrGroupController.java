package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.convert.AttrGroupConvert;
import com.qinweizhao.product.model.dto.AttrGroupWithAttrsDTO;
import com.qinweizhao.product.model.entity.PmsAttrGroup;
import com.qinweizhao.product.model.vo.AttrGroupVO;
import com.qinweizhao.product.model.vo.AttrGroupWithAttrsVO;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public R<AttrGroupVO> get(@PathVariable("attrGroupId") Long attrGroupId) {
        PmsAttrGroup pmsAttrGroup = pmsAttrGroupService.getById(attrGroupId);
        String dbCategoryPath = pmsAttrGroup.getCategoryPath();
        AttrGroupVO attrGroupVO = new AttrGroupVO();
        List<Long> categoryPath = Arrays.stream(dbCategoryPath.split(",")).map(Long::parseLong).collect(Collectors.toList());
        attrGroupVO.setCategoryPath(categoryPath);
        BeanUtils.copyProperties(pmsAttrGroup, attrGroupVO);
        return R.success(attrGroupVO);
    }

    /**
     * 新增属性分组
     */
    @RequiresPermissions("product:group:add")
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.success(pmsAttrGroupService.save(pmsAttrGroup));
    }

    /**
     * 修改属性分组
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.success(pmsAttrGroupService.updateById(pmsAttrGroup));
    }

    /**
     * 删除属性分组
     */
    @RequiresPermissions("product:group:remove")
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrGroupIds}")
    public R<?> remove(@PathVariable Long[] attrGroupIds) {
        return R.success(pmsAttrGroupService.removeByIds(attrGroupIds));
    }


    /**
     * 通过分类 id 获取分属性组和组中属性
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{categoryId}/attr")
    public R<List<AttrGroupWithAttrsVO>> getAttrGroupWithAttrs(@PathVariable("categoryId") Long categoryId) {
        List<AttrGroupWithAttrsDTO> attrGroupWithAttrs = pmsAttrGroupService.listAttrGroupWithAttrsByCategoryId(categoryId);
        return R.success(AttrGroupConvert.INSTANCE.convertToVO(attrGroupWithAttrs));
    }


}
