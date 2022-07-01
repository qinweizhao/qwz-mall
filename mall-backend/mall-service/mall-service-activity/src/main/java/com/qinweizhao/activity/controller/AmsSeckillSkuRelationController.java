package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsSeckillSkuRelation;
import com.qinweizhao.activity.service.IAmsSeckillSkuRelationService;
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
 * 秒杀活动商品关联Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/relation")
public class AmsSeckillSkuRelationController {
    @Resource
    private IAmsSeckillSkuRelationService amsSeckillSkuRelationService;

    /**
     * 查询秒杀活动商品关联列表
     */
    @RequiresPermissions("activity:relation:list")
    @GetMapping("/list")
    public R<List<AmsSeckillSkuRelation>> list(AmsSeckillSkuRelation amsSeckillSkuRelation) {

        List<AmsSeckillSkuRelation> list = amsSeckillSkuRelationService.selectAmsSeckillSkuRelationList(amsSeckillSkuRelation);
        return R.success(list);
    }

    /**
     * 导出秒杀活动商品关联列表
     */
    @RequiresPermissions("activity:relation:export")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSeckillSkuRelation amsSeckillSkuRelation) {
        List<AmsSeckillSkuRelation> list = amsSeckillSkuRelationService.selectAmsSeckillSkuRelationList(amsSeckillSkuRelation);
        ExcelUtil<AmsSeckillSkuRelation> util = new ExcelUtil<AmsSeckillSkuRelation>(AmsSeckillSkuRelation.class);
        util.exportExcel(response, list, "秒杀活动商品关联数据");
        return R.success();
    }

    /**
     * 获取秒杀活动商品关联详细信息
     */
    @RequiresPermissions("activity:relation:query")
    @GetMapping(value = "/{id}")
    public R<AmsSeckillSkuRelation> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSeckillSkuRelationService.selectAmsSeckillSkuRelationById(id));
    }

    /**
     * 新增秒杀活动商品关联
     */
    @RequiresPermissions("activity:relation:add")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSeckillSkuRelation amsSeckillSkuRelation) {
        return R.success(amsSeckillSkuRelationService.insertAmsSeckillSkuRelation(amsSeckillSkuRelation));
    }

    /**
     * 修改秒杀活动商品关联
     */
    @RequiresPermissions("activity:relation:edit")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSeckillSkuRelation amsSeckillSkuRelation) {
        return R.success(amsSeckillSkuRelationService.updateAmsSeckillSkuRelation(amsSeckillSkuRelation));
    }

    /**
     * 删除秒杀活动商品关联
     */
    @RequiresPermissions("activity:relation:remove")
    @Log(title = "秒杀活动商品关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsSeckillSkuRelationService.deleteAmsSeckillSkuRelationByIds(ids));
    }
}
