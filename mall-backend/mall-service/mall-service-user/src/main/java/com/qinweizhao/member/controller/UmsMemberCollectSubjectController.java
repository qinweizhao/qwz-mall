package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.UmsMemberCollectSubject;
import com.qinweizhao.product.service.IUmsMemberCollectSubjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员收藏的专题活动Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/subject")
public class UmsMemberCollectSubjectController extends BaseController {
    @Resource
    private IUmsMemberCollectSubjectService umsMemberCollectSubjectService;

    /**
     * 查询会员收藏的专题活动列表
     */
    @RequiresPermissions("product:subject:list")
    @GetMapping("/list")
    public R<List<UmsMemberCollectSubject>> list(UmsMemberCollectSubject umsMemberCollectSubject) {
        startPage();
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.selectUmsMemberCollectSubjectList(umsMemberCollectSubject);
        return R.success(list);
    }

    /**
     * 导出会员收藏的专题活动列表
     */
    @RequiresPermissions("product:subject:export")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMemberCollectSubject umsMemberCollectSubject) {
        List<UmsMemberCollectSubject> list = umsMemberCollectSubjectService.selectUmsMemberCollectSubjectList(umsMemberCollectSubject);
        ExcelUtil<UmsMemberCollectSubject> util = new ExcelUtil<UmsMemberCollectSubject>(UmsMemberCollectSubject.class);
        util.exportExcel(response, list, "会员收藏的专题活动数据");
        return R.success();
    }

    /**
     * 获取会员收藏的专题活动详细信息
     */
    @RequiresPermissions("product:subject:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberCollectSubject> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberCollectSubjectService.selectUmsMemberCollectSubjectById(id));
    }

    /**
     * 新增会员收藏的专题活动
     */
    @RequiresPermissions("product:subject:add")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject) {
        return R.condition(umsMemberCollectSubjectService.insertUmsMemberCollectSubject(umsMemberCollectSubject));
    }

    /**
     * 修改会员收藏的专题活动
     */
    @RequiresPermissions("product:subject:edit")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMemberCollectSubject umsMemberCollectSubject) {
        return R.condition(umsMemberCollectSubjectService.updateUmsMemberCollectSubject(umsMemberCollectSubject));
    }

    /**
     * 删除会员收藏的专题活动
     */
    @RequiresPermissions("product:subject:remove")
    @Log(title = "会员收藏的专题活动", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsMemberCollectSubjectService.deleteUmsMemberCollectSubjectByIds(ids));
    }
}
