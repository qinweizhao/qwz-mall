package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsHomeSubject;
import com.qinweizhao.activity.service.IAmsHomeSubjectService;
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
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/subject")
public class AmsHomeSubjectController {
    @Resource
    private IAmsHomeSubjectService amsHomeSubjectService;

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     */
    @RequiresPermissions("activity:subject:list")
    @GetMapping("/list")
    public R<List<AmsHomeSubject>> list(AmsHomeSubject amsHomeSubject) {

        List<AmsHomeSubject> list = amsHomeSubjectService.selectAmsHomeSubjectList(amsHomeSubject);
        return R.success(list);
    }

    /**
     * 导出首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     */
    @RequiresPermissions("activity:subject:export")
    @Log(title = "首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsHomeSubject amsHomeSubject) {
        List<AmsHomeSubject> list = amsHomeSubjectService.selectAmsHomeSubjectList(amsHomeSubject);
        ExcelUtil<AmsHomeSubject> util = new ExcelUtil<AmsHomeSubject>(AmsHomeSubject.class);
        util.exportExcel(response, list, "首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】数据");
        return R.success();
    }

    /**
     * 获取首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】详细信息
     */
    @RequiresPermissions("activity:subject:query")
    @GetMapping(value = "/{id}")
    public R<AmsHomeSubject> getInfo(@PathVariable("id") Long id) {
        return R.success(amsHomeSubjectService.getById(id));
    }

    /**
     * 新增首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    @RequiresPermissions("activity:subject:add")
    @Log(title = "首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsHomeSubject amsHomeSubject) {
        return R.success(amsHomeSubjectService.save(amsHomeSubject));
    }

    /**
     * 修改首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    @RequiresPermissions("activity:subject:edit")
    @Log(title = "首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsHomeSubject amsHomeSubject) {
        return R.success(amsHomeSubjectService.updateById(amsHomeSubject));
    }

    /**
     * 删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    @RequiresPermissions("activity:subject:remove")
    @Log(title = "首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsHomeSubjectService.removeById(id));
    }
}
