package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsHomeSubjectSpu;
import com.qinweizhao.activity.service.IAmsHomeSubjectSpuService;
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
 * 专题商品Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/spu")
public class AmsHomeSubjectSpuController {
    @Resource
    private IAmsHomeSubjectSpuService amsHomeSubjectSpuService;

    /**
     * 查询专题商品列表
     */
    @RequiresPermissions("activity:spu:list")
    @GetMapping("/list")
    public R<List<AmsHomeSubjectSpu>> list(AmsHomeSubjectSpu amsHomeSubjectSpu) {

        List<AmsHomeSubjectSpu> list = amsHomeSubjectSpuService.selectAmsHomeSubjectSpuList(amsHomeSubjectSpu);
        return R.success(list);
    }

    /**
     * 导出专题商品列表
     */
    @RequiresPermissions("activity:spu:export")
    @Log(title = "专题商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsHomeSubjectSpu amsHomeSubjectSpu) {
        List<AmsHomeSubjectSpu> list = amsHomeSubjectSpuService.selectAmsHomeSubjectSpuList(amsHomeSubjectSpu);
        ExcelUtil<AmsHomeSubjectSpu> util = new ExcelUtil<AmsHomeSubjectSpu>(AmsHomeSubjectSpu.class);
        util.exportExcel(response, list, "专题商品数据");
        return R.success();
    }

    /**
     * 获取专题商品详细信息
     */
    @RequiresPermissions("activity:spu:query")
    @GetMapping(value = "/{id}")
    public R<AmsHomeSubjectSpu> getInfo(@PathVariable("id") Long id) {
        return R.success(amsHomeSubjectSpuService.selectAmsHomeSubjectSpuById(id));
    }

    /**
     * 新增专题商品
     */
    @RequiresPermissions("activity:spu:add")
    @Log(title = "专题商品", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsHomeSubjectSpu amsHomeSubjectSpu) {
        return R.success(amsHomeSubjectSpuService.insertAmsHomeSubjectSpu(amsHomeSubjectSpu));
    }

    /**
     * 修改专题商品
     */
    @RequiresPermissions("activity:spu:edit")
    @Log(title = "专题商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsHomeSubjectSpu amsHomeSubjectSpu) {
        return R.success(amsHomeSubjectSpuService.updateAmsHomeSubjectSpu(amsHomeSubjectSpu));
    }

    /**
     * 删除专题商品
     */
    @RequiresPermissions("activity:spu:remove")
    @Log(title = "专题商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsHomeSubjectSpuService.deleteAmsHomeSubjectSpuByIds(ids));
    }
}
