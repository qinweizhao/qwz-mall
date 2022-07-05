package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsMemberLevel;
import com.qinweizhao.user.service.UmsMemberLevelService;
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
public class UmsMemberLevelController {


    private final UmsMemberLevelService umsMemberLevelService;

    /**
     * 查询会员等级列表
     */
    @RequiresPermissions("product:level:list")
    @GetMapping("/list")
    public R<List<UmsMemberLevel>> list() {
        List<UmsMemberLevel> list = umsMemberLevelService.list();
        return R.success(list);
    }

    /**
     * 查询会员等级列表
     */
    @RequiresPermissions("product:level:page")
    @GetMapping("/page")
    public R<List<UmsMemberLevel>> page() {
        List<UmsMemberLevel> list = umsMemberLevelService.list();
        return R.success(list);
    }


    /**
     * 获取会员等级详细信息
     */
    @RequiresPermissions("product:level:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberLevel> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberLevelService.getById(id));
    }

    /**
     * 新增会员等级
     */
    @RequiresPermissions("product:level:add")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsMemberLevel umsMemberLevel) {
        return R.success(umsMemberLevelService.save(umsMemberLevel));
    }

    /**
     * 修改会员等级
     */
    @RequiresPermissions("product:level:edit")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsMemberLevel umsMemberLevel) {
        return R.success(umsMemberLevelService.updateById(umsMemberLevel));
    }

    /**
     * 删除会员等级
     */
    @RequiresPermissions("product:level:remove")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsMemberLevelService.removeBatchByIds(ids));
    }
}
