package com.mall4j.cloud.product.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * spu信息DTO
 *
 * @author FrozenWatermelon
 * @date 2020-10-28 15:27:24
 */
public class SpuPageSearchDTO {

	@ApiModelProperty("spuId")
	private Long spuId;

	@ApiModelProperty("品牌ID")
	private Long brandId;

	@ApiModelProperty("分类ID")
	private Long categoryId;

	@ApiModelProperty("spu名称")
	private String name;

	@ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
	private Integer status;

	@ApiModelProperty("spuId列表(商品上下架：批量操作时，用此参数)(批量处理参数)")
	private List<Long> spuIds;

	@ApiModelProperty("商品状态： 0.全部  1.销售中  2.已售罄  3.已下架 ")
	private Integer spuStatus;

	@ApiModelProperty("最低价")
	private Long minPrice;

	@ApiModelProperty("最高价")
	private Long maxPrice;

	@ApiModelProperty("最低销量")
	private Long minSaleNum;

	@ApiModelProperty("最高销量")
	private Long maxSaleNum;

	@ApiModelProperty("商品编码")
	private String partyCode;

	@ApiModelProperty("当前价排序 0：倒序 1：顺序")
	private Integer priceFeeSort;

	@ApiModelProperty("市场价排序 0：倒序 1：顺序")
	private Integer marketPriceFeeSort;

	@ApiModelProperty("销量排序 0：倒序 1：顺序")
	private Integer saleNumSort;

	@ApiModelProperty("库存排序 0：倒序 1：顺序")
	private Integer stockSort;

	@ApiModelProperty("序号排序 0：倒序 1：顺序")
	private Integer seqSort;

	@ApiModelProperty("创建时间排序 0：倒序 1：顺序")
	private Integer createTimeSort;


	public Long getSpuId() {
		return spuId;
	}

	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Long> getSpuIds() {
		return spuIds;
	}

	public void setSpuIds(List<Long> spuIds) {
		this.spuIds = spuIds;
	}

	public Integer getSpuStatus() {
		return spuStatus;
	}

	public void setSpuStatus(Integer spuStatus) {
		this.spuStatus = spuStatus;
	}

	public Long getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Long minPrice) {
		this.minPrice = minPrice;
	}

	public Long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Long maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Long getMinSaleNum() {
		return minSaleNum;
	}

	public void setMinSaleNum(Long minSaleNum) {
		this.minSaleNum = minSaleNum;
	}

	public Long getMaxSaleNum() {
		return maxSaleNum;
	}

	public void setMaxSaleNum(Long maxSaleNum) {
		this.maxSaleNum = maxSaleNum;
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	public Integer getPriceFeeSort() {
		return priceFeeSort;
	}

	public void setPriceFeeSort(Integer priceFeeSort) {
		this.priceFeeSort = priceFeeSort;
	}

	public Integer getMarketPriceFeeSort() {
		return marketPriceFeeSort;
	}

	public void setMarketPriceFeeSort(Integer marketPriceFeeSort) {
		this.marketPriceFeeSort = marketPriceFeeSort;
	}

	public Integer getSaleNumSort() {
		return saleNumSort;
	}

	public void setSaleNumSort(Integer saleNumSort) {
		this.saleNumSort = saleNumSort;
	}

	public Integer getStockSort() {
		return stockSort;
	}

	public void setStockSort(Integer stockSort) {
		this.stockSort = stockSort;
	}

	public Integer getSeqSort() {
		return seqSort;
	}

	public void setSeqSort(Integer seqSort) {
		this.seqSort = seqSort;
	}

	public Integer getCreateTimeSort() {
		return createTimeSort;
	}

	public void setCreateTimeSort(Integer createTimeSort) {
		this.createTimeSort = createTimeSort;
	}

	@Override
	public String toString() {
		return "SpuPageSearchDTO{" +
				"spuId=" + spuId +
				", brandId=" + brandId +
				", categoryId=" + categoryId +
				", name='" + name + '\'' +
				", status=" + status +
				", spuIds=" + spuIds +
				", spuStatus=" + spuStatus +
				", minPrice=" + minPrice +
				", maxPrice=" + maxPrice +
				", minSaleNum=" + minSaleNum +
				", maxSaleNum=" + maxSaleNum +
				", partyCode='" + partyCode + '\'' +
				", priceFeeSort=" + priceFeeSort +
				", marketPriceFeeSort=" + marketPriceFeeSort +
				", saleNumSort=" + saleNumSort +
				", stockSort=" + stockSort +
				", seqSort=" + seqSort +
				", createTimeSort=" + createTimeSort +
				'}';
	}
}
