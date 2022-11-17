package com.qinweizhao.system.pojo.query;

import com.qinweizhao.system.pojo.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("客户端分页查询对象")
@Data
public class ClientPageQuery extends BasePageQuery {

    @ApiModelProperty("关键字(客户端ID)")
    private String keywords;
}
