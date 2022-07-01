package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 秒杀活动场次对象 ams_seckill_session
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_seckill_session")
public class AmsSeckillSession extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 场次名称
     */
    @Excel(name = "场次名称")
    private String name;

    /**
     * 每日开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "每日开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 每日结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "每日结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 启用状态
     */
    @Excel(name = "启用状态")
    private Integer status;

}
