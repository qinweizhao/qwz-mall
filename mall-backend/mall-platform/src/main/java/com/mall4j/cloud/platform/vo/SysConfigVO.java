package com.mall4j.cloud.platform.vo;

import com.mall4j.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统配置信息表VO
 *
 * @author lhd
 * @date 2020-12-23 16:27:57
 */
public class SysConfigVO extends BaseVO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("key")
    private String paramKey;

    @ApiModelProperty("value")
    private String paramValue;

    @ApiModelProperty("备注")
    private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysConfigVO{" +
				"id=" + id +
				",paramKey=" + paramKey +
				",paramValue=" + paramValue +
				",remark=" + remark +
				'}';
	}
}
