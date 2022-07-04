package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsSeckillPromotion;
import com.qinweizhao.activity.service.IAmsSeckillPromotionService;
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
 * 秒杀活动Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/promotion")
public class AmsSeckillPromotionController {
    @Resource
    private IAmsSeckillPromotionService amsSeckillPromotionService;

    /**
     * 查询秒杀活动列表
     */
    @RequiresPermissions("activity:promotion:list")
    @GetMapping("/list")
    public R<List<AmsSeckillPromotion>> list(AmsSeckillPromotion amsSeckillPromotion) {

        List<AmsSeckillPromotion> list = amsSeckillPromotionService.selectAmsSeckillPromotionList(amsSeckillPromotion);
        return R.success(list);
    }

    /**
     * 导出秒杀活动列表
     */
    @RequiresPermissions("activity:promotion:export")
    @Log(title = "秒杀活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSeckillPromotion amsSeckillPromotion) {
        List<AmsSeckillPromotion> list = amsSeckillPromotionService.selectAmsSeckillPromotionList(amsSeckillPromotion);
        ExcelUtil<AmsSeckillPromotion> util = new ExcelUtil<AmsSeckillPromotion>(AmsSeckillPromotion.class);
        util.exportExcel(response, list, "秒杀活动数据");
        return R.success();
    }

    /**
     * 获取秒杀活动详细信息
     */
    @RequiresPermissions("activity:promotion:query")
    @GetMapping(value = "/{id}")
    public R<AmsSeckillPromotion> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSeckillPromotionService.getById(id));
    }

    /**
     * 新增秒杀活动
     */
    @RequiresPermissions("activity:promotion:add")
    @Log(title = "秒杀活动", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSeckillPromotion amsSeckillPromotion) {
        return R.success(amsSeckillPromotionService.save(amsSeckillPromotion));
    }

    /**
     * 修改秒杀活动
     */
    @RequiresPermissions("activity:promotion:edit")
    @Log(title = "秒杀活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSeckillPromotion amsSeckillPromotion) {
        return R.success(amsSeckillPromotionService.updateById(amsSeckillPromotion));
    }

    /**
     * 删除秒杀活动
     */
    @RequiresPermissions("activity:promotion:remove")
    @Log(title = "秒杀活动", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsSeckillPromotionService.removeById(id));
    }
}
