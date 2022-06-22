package com.qinweizhao.ware.model.param;

import com.qinweizhao.component.core.entity.BaseEntity;
import com.qinweizhao.component.core.request.PageParam;
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
public class WareInfoPageParam extends PageParam {
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
