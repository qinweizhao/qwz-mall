package com.qinweizhao.ware.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仓库信息对象 wms_ware_info
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WmsWareInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 仓库名
     */
    private String name;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 区域编码
     */
    private String areacode;


}
