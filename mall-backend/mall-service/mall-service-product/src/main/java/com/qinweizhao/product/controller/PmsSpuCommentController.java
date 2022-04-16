package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsSpuComment;
import com.qinweizhao.product.service.IPmsSpuCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品评价Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/spu/comment")
public class PmsSpuCommentController extends BaseController {
    @Resource
    private IPmsSpuCommentService pmsSpuCommentService;

    /**
     * 查询商品评价列表
     */
    @RequiresPermissions("product:comment:list")
    @GetMapping("/list")
    public R<List<PmsSpuComment>> list(PmsSpuComment pmsSpuComment) {
        startPage();
        List<PmsSpuComment> list = pmsSpuCommentService.selectPmsSpuCommentList(pmsSpuComment);
        return R.success(list);
    }

    /**
     * 导出商品评价列表
     */
    @RequiresPermissions("product:comment:export")
    @Log(title = "商品评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSpuComment pmsSpuComment) {
        List<PmsSpuComment> list = pmsSpuCommentService.selectPmsSpuCommentList(pmsSpuComment);
        ExcelUtil<PmsSpuComment> util = new ExcelUtil<PmsSpuComment>(PmsSpuComment.class);
        util.exportExcel(response, list, "商品评价数据");
        return R.success();
    }

    /**
     * 获取商品评价详细信息
     */
    @RequiresPermissions("product:comment:query")
    @GetMapping(value = "/{id}")
    public R<PmsSpuComment> getInfo(@PathVariable("id") Long id) {
        return R.success(pmsSpuCommentService.selectPmsSpuCommentById(id));
    }

    /**
     * 新增商品评价
     */
    @RequiresPermissions("product:comment:add")
    @Log(title = "商品评价", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSpuComment pmsSpuComment) {
        return R.condition(pmsSpuCommentService.insertPmsSpuComment(pmsSpuComment));
    }

    /**
     * 修改商品评价
     */
    @RequiresPermissions("product:comment:edit")
    @Log(title = "商品评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSpuComment pmsSpuComment) {
        return R.condition(pmsSpuCommentService.updatePmsSpuComment(pmsSpuComment));
    }

    /**
     * 删除商品评价
     */
    @RequiresPermissions("product:comment:remove")
    @Log(title = "商品评价", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(pmsSpuCommentService.deletePmsSpuCommentByIds(ids));
    }
}
