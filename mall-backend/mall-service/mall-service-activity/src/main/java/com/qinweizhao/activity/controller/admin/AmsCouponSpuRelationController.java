package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsCouponSpuRelation;
import com.qinweizhao.activity.service.IAmsCouponSpuRelationService;
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
 * 优惠券与产品关联Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/1/relation")
public class AmsCouponSpuRelationController {
    @Resource
    private IAmsCouponSpuRelationService amsCouponSpuRelationService;

    /**
     * 查询优惠券与产品关联列表
     */
    @RequiresPermissions("activity:relation:list")
    @GetMapping("/list")
    public R<List<AmsCouponSpuRelation>> list(AmsCouponSpuRelation amsCouponSpuRelation) {

        List<AmsCouponSpuRelation> list = amsCouponSpuRelationService.selectAmsCouponSpuRelationList(amsCouponSpuRelation);
        return R.success(list);
    }

    /**
     * 导出优惠券与产品关联列表
     */
    @RequiresPermissions("activity:relation:export")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsCouponSpuRelation amsCouponSpuRelation) {
        List<AmsCouponSpuRelation> list = amsCouponSpuRelationService.selectAmsCouponSpuRelationList(amsCouponSpuRelation);
        ExcelUtil<AmsCouponSpuRelation> util = new ExcelUtil<AmsCouponSpuRelation>(AmsCouponSpuRelation.class);
        util.exportExcel(response, list, "优惠券与产品关联数据");
        return R.success();
    }

    /**
     * 获取优惠券与产品关联详细信息
     */
    @RequiresPermissions("activity:relation:query")
    @GetMapping(value = "/{id}")
    public R<AmsCouponSpuRelation> getInfo(@PathVariable("id") Long id) {
        return R.success(amsCouponSpuRelationService.getById(id));
    }

    /**
     * 新增优惠券与产品关联
     */
    @RequiresPermissions("activity:relation:add")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsCouponSpuRelation amsCouponSpuRelation) {
        return R.success(amsCouponSpuRelationService.save(amsCouponSpuRelation));
    }

    /**
     * 修改优惠券与产品关联
     */
    @RequiresPermissions("activity:relation:edit")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsCouponSpuRelation amsCouponSpuRelation) {
        return R.success(amsCouponSpuRelationService.updateById(amsCouponSpuRelation));
    }

    /**
     * 删除优惠券与产品关联
     */
    @RequiresPermissions("activity:relation:remove")
    @Log(title = "优惠券与产品关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsCouponSpuRelationService.removeById(id));
    }
}
