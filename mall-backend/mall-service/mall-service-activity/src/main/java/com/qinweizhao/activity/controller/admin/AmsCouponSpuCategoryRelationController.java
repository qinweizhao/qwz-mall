package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsCouponSpuCategoryRelation;
import com.qinweizhao.activity.service.IAmsCouponSpuCategoryRelationService;
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
 * 优惠券分类关联Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("coupon/category/relation")
public class AmsCouponSpuCategoryRelationController {
    @Resource
    private IAmsCouponSpuCategoryRelationService amsCouponSpuCategoryRelationService;

    /**
     * 查询优惠券分类关联列表
     */
    @RequiresPermissions("activity:relation:list")
    @GetMapping("/list")
    public R<List<AmsCouponSpuCategoryRelation>> list(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {

        List<AmsCouponSpuCategoryRelation> list = amsCouponSpuCategoryRelationService.selectAmsCouponSpuCategoryRelationList(amsCouponSpuCategoryRelation);
        return R.success(list);
    }

    /**
     * 导出优惠券分类关联列表
     */
    @RequiresPermissions("activity:relation:export")
    @Log(title = "优惠券分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        List<AmsCouponSpuCategoryRelation> list = amsCouponSpuCategoryRelationService.selectAmsCouponSpuCategoryRelationList(amsCouponSpuCategoryRelation);
        ExcelUtil<AmsCouponSpuCategoryRelation> util = new ExcelUtil<AmsCouponSpuCategoryRelation>(AmsCouponSpuCategoryRelation.class);
        util.exportExcel(response, list, "优惠券分类关联数据");
        return R.success();
    }

    /**
     * 获取优惠券分类关联详细信息
     */
    @RequiresPermissions("activity:relation:query")
    @GetMapping(value = "/{id}")
    public R<AmsCouponSpuCategoryRelation> getInfo(@PathVariable("id") Long id) {
        return R.success(amsCouponSpuCategoryRelationService.getById(id));
    }

    /**
     * 新增优惠券分类关联
     */
    @RequiresPermissions("activity:relation:add")
    @Log(title = "优惠券分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        return R.success(amsCouponSpuCategoryRelationService.save(amsCouponSpuCategoryRelation));
    }

    /**
     * 修改优惠券分类关联
     */
    @RequiresPermissions("activity:relation:edit")
    @Log(title = "优惠券分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        return R.success(amsCouponSpuCategoryRelationService.updateById(amsCouponSpuCategoryRelation));
    }

    /**
     * 删除优惠券分类关联
     */
    @RequiresPermissions("activity:relation:remove")
    @Log(title = "优惠券分类关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsCouponSpuCategoryRelationService.removeById(id));
    }
}
