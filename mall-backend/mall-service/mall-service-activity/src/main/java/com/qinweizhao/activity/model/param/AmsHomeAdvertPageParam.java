package com.qinweizhao.activity.model.param;

import com.qinweizhao.component.core.request.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qinweizhao
 * @since 2022/7/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AmsHomeAdvertPageParam extends PageParam {

    private static final long serialVersionUID = 1L;

    /**
     * εε­
     */
    private String name;


    /**
     * ηΆζ
     */
    private Integer status;

}
