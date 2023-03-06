package com.mall4j.cloud.product.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 属性信息DTO
 *
 * @author FrozenWatermelon
 * @date 2020-10-28 15:27:23
 */
public class AttrDTO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("attr id")
    private Long attrId;

	@ApiModelProperty("店铺id")
	private Long shopId;

	@NotNull(message = "属性名称不能为空")
    @ApiModelProperty("属性名称")
    private String name;

	@ApiModelProperty("属性描述")
    private String desc;

	@ApiModelProperty("作为搜索参数 0:不需要，1:需要")
	private Integer searchType;

	@ApiModelProperty("属性类型 0:销售属性，1:基本属性")
	private Integer attrType;

	@ApiModelProperty("分类id列表")
	private List<Long> categoryIds;

    @ApiModelProperty("属性值列表")
	private List<AttrValueDTO> attrValues;

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getAttrType() {
		return attrType;
	}

	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public List<AttrValueDTO> getAttrValues() {
		return attrValues;
	}

	public void setAttrValues(List<AttrValueDTO> attrValues) {
		this.attrValues = attrValues;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	@Override
	public String toString() {
		return "AttrDTO{" +
				"attrId=" + attrId +
				", shopId='" + shopId + '\'' +
				", name='" + name + '\'' +
				", desc='" + desc + '\'' +
				", attrType=" + attrType +
				", searchType=" + searchType +
				", categoryIds=" + categoryIds +
				", attrValues=" + attrValues +
				'}';
	}
}
