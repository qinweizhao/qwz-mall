package com.qinweizhao.system.pojo.query;


import com.qinweizhao.system.pojo.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("字典数据项分页查询对象")
@Data
public class DictItemPageQuery extends BasePageQuery {

    @ApiModelProperty("关键字(字典项名称)")
    private String keywords;

    @ApiModelProperty("字典类型编码")
    private String typeCode;
}
