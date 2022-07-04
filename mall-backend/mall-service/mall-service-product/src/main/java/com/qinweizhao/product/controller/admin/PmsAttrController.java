package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.constant.ProductConstant;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.entity.PmsAttrAttrGroup;
import com.qinweizhao.product.model.vo.AttrVO;
import com.qinweizhao.product.model.param.AttrParam;
import com.qinweizhao.product.service.IPmsAttrAttrGroupService;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private IPmsAttrAttrGroupService pmsAttrAttrGroupService;

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
    public R<AttrVO> getInfo(@PathVariable("attrId") Long attrId) {
        PmsAttr pmsAttr = pmsAttrService.getById(attrId);
        String dbCategoryPath = pmsAttr.getCategoryPath();
        AttrVO attrVO = new AttrVO();
        List<Long> categoryPath = Arrays.stream(dbCategoryPath.split(",")).map(Long::parseLong).collect(Collectors.toList());
        attrVO.setCategoryPath(categoryPath);
        BeanUtils.copyProperties(pmsAttr, attrVO);
        if(pmsAttr.getType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            PmsAttrAttrGroup pmsAttrAttrGroup = pmsAttrAttrGroupService.selectByAttrId(attrId);
            if (pmsAttrAttrGroup!=null){
                attrVO.setAttrGroupId(pmsAttrAttrGroup.getAttrGroupId());
            }
        }
        return R.success(attrVO);
    }

    /**
     * 新增商品属性
     */
    @RequiresPermissions("product:attr:add")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AttrParam pmsAttr) {
        return R.success(pmsAttrService.save(pmsAttr));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AttrParam pmsAttr) {
        return R.success(pmsAttrService.updateById(pmsAttr));
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrIds}")
    public R<?> remove(@PathVariable Long[] attrIds) {
        return R.success(pmsAttrService.removeByIds(attrIds));
    }
}
