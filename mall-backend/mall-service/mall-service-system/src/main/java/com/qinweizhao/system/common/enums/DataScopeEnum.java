package com.qinweizhao.system.common.enums;

import com.qinweizhao.system.common.base.IBaseEnum;
import lombok.Getter;

/**
 * 数据权限枚举
 *
 * @author haoxr
 * @date 2022/10/14
 */
public enum DataScopeEnum implements IBaseEnum<Integer> {

    /**
     * value 越小，数据权限范围越大
     */
    ALL(0, "所有数据"),
    DEPT_AND_SUB(10, "部门及子部门数据"),
    DEPT(20, "本部门数据"),
    SELF(30, "本人数据");

    @Getter
    private Integer value;

    @Getter
    private String label;

    DataScopeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
