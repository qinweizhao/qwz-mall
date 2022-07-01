package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsSeckillSession;
import com.qinweizhao.activity.service.IAmsSeckillSessionService;
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
 * 秒杀活动场次Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/session")
public class AmsSeckillSessionController {
    @Resource
    private IAmsSeckillSessionService amsSeckillSessionService;

    /**
     * 查询秒杀活动场次列表
     */
    @RequiresPermissions("activity:session:list")
    @GetMapping("/list")
    public R<List<AmsSeckillSession>> list(AmsSeckillSession amsSeckillSession) {

        List<AmsSeckillSession> list = amsSeckillSessionService.selectAmsSeckillSessionList(amsSeckillSession);
        return R.success(list);
    }

    /**
     * 导出秒杀活动场次列表
     */
    @RequiresPermissions("activity:session:export")
    @Log(title = "秒杀活动场次", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSeckillSession amsSeckillSession) {
        List<AmsSeckillSession> list = amsSeckillSessionService.selectAmsSeckillSessionList(amsSeckillSession);
        ExcelUtil<AmsSeckillSession> util = new ExcelUtil<AmsSeckillSession>(AmsSeckillSession.class);
        util.exportExcel(response, list, "秒杀活动场次数据");
        return R.success();
    }

    /**
     * 获取秒杀活动场次详细信息
     */
    @RequiresPermissions("activity:session:query")
    @GetMapping(value = "/{id}")
    public R<AmsSeckillSession> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSeckillSessionService.selectAmsSeckillSessionById(id));
    }

    /**
     * 新增秒杀活动场次
     */
    @RequiresPermissions("activity:session:add")
    @Log(title = "秒杀活动场次", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSeckillSession amsSeckillSession) {
        return R.success(amsSeckillSessionService.insertAmsSeckillSession(amsSeckillSession));
    }

    /**
     * 修改秒杀活动场次
     */
    @RequiresPermissions("activity:session:edit")
    @Log(title = "秒杀活动场次", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSeckillSession amsSeckillSession) {
        return R.success(amsSeckillSessionService.updateAmsSeckillSession(amsSeckillSession));
    }

    /**
     * 删除秒杀活动场次
     */
    @RequiresPermissions("activity:session:remove")
    @Log(title = "秒杀活动场次", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsSeckillSessionService.deleteAmsSeckillSessionByIds(ids));
    }
}
