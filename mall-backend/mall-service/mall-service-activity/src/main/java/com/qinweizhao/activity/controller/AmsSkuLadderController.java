package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsSkuLadder;
import com.qinweizhao.activity.service.IAmsSkuLadderService;
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
 * 商品阶梯价格Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/ladder")
public class AmsSkuLadderController {
    @Resource
    private IAmsSkuLadderService amsSkuLadderService;

    /**
     * 查询商品阶梯价格列表
     */
    @RequiresPermissions("activity:ladder:list")
    @GetMapping("/list")
    public R<List<AmsSkuLadder>> list(AmsSkuLadder amsSkuLadder) {

        List<AmsSkuLadder> list = amsSkuLadderService.selectAmsSkuLadderList(amsSkuLadder);
        return R.success(list);
    }

    /**
     * 导出商品阶梯价格列表
     */
    @RequiresPermissions("activity:ladder:export")
    @Log(title = "商品阶梯价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSkuLadder amsSkuLadder) {
        List<AmsSkuLadder> list = amsSkuLadderService.selectAmsSkuLadderList(amsSkuLadder);
        ExcelUtil<AmsSkuLadder> util = new ExcelUtil<AmsSkuLadder>(AmsSkuLadder.class);
        util.exportExcel(response, list, "商品阶梯价格数据");
        return R.success();
    }

    /**
     * 获取商品阶梯价格详细信息
     */
    @RequiresPermissions("activity:ladder:query")
    @GetMapping(value = "/{id}")
    public R<AmsSkuLadder> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSkuLadderService.getById(id));
    }

    /**
     * 新增商品阶梯价格
     */
    @RequiresPermissions("activity:ladder:add")
    @Log(title = "商品阶梯价格", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSkuLadder amsSkuLadder) {
        return R.success(amsSkuLadderService.save(amsSkuLadder));
    }

    /**
     * 修改商品阶梯价格
     */
    @RequiresPermissions("activity:ladder:edit")
    @Log(title = "商品阶梯价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSkuLadder amsSkuLadder) {
        return R.success(amsSkuLadderService.updateById(amsSkuLadder));
    }

    /**
     * 删除商品阶梯价格
     */
    @RequiresPermissions("activity:ladder:remove")
    @Log(title = "商品阶梯价格", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsSkuLadderService.removeById(id));
    }
}
