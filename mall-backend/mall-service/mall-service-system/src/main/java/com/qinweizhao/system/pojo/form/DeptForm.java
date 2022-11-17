package com.qinweizhao.system.pojo.form;

import com.qinweizhao.component.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel("部门表单对象")
@Data
public class DeptForm extends BaseEntity {

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("父部门ID")
    @NotNull(message = "父部门ID不能为空")
    private Long parentId;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("排序")
    private Integer sort;

}
