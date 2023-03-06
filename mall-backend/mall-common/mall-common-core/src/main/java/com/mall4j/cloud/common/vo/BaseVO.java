package com.mall4j.cloud.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 阿里java开发手册： 【强制】表必备三字段：id, create_time, update_time。 说明：其中 id 必为主键，类型为 bigint
 * unsigned、单表时自增、步长为 1。create_time, update_time 的类型均为 datetime
 * 类型，前者现在时表示主动式创建，后者过去分词表示被动式更新。
 *
 * @author FrozenWatermelon
 */
public class BaseVO {

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	protected Date createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	protected Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "BaseDTO{" + "createTime=" + createTime + ", updateTime=" + updateTime + '}';
	}

}
