package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsLevel;
import com.qinweizhao.user.service.UmsLevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员等级Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/level")
@AllArgsConstructor
public class UmsLevelController {


    private final UmsLevelService umsLevelService;

    /**
     * 查询会员等级列表
     */
    @RequiresPermissions("product:level:list")
    @GetMapping("/list")
    public R<List<UmsLevel>> list() {
//        List<UmsLevel> list = umsLevelService.list();
//        return R.success(list);
        return R.success();
    }

    /**
     * 查询会员等级列表
     */
    @RequiresPermissions("product:level:page")
    @GetMapping("/page")
    public R<List<UmsLevel>> page() {
//        List<UmsLevel> list = umsLevelService.list();
//        return R.success(list);
        return R.success();
    }


    /**
     * 获取会员等级详细信息
     */
    @RequiresPermissions("product:level:query")
    @GetMapping(value = "/{id}")
    public R<UmsLevel> getInfo(@PathVariable("id") Long id) {
//        return R.success(umsLevelService.getById(id));
        return R.success();
    }

    /**
     * 新增会员等级
     */
    @RequiresPermissions("product:level:add")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsLevel umsLevel) {
        return R.success(umsLevelService.save(umsLevel));
    }

    /**
     * 修改会员等级
     */
    @RequiresPermissions("product:level:edit")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsLevel umsLevel) {
        return R.success(umsLevelService.updateById(umsLevel));
    }

    /**
     * 删除会员等级
     */
    @RequiresPermissions("product:level:remove")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsLevelService.removeBatchByIds(ids));
    }
}
