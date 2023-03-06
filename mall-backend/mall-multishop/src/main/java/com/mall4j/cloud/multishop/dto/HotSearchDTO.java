package com.mall4j.cloud.multishop.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 热搜DTO
 *
 * @author YXF
 * @date 2021-01-27 09:10:00
 */
public class HotSearchDTO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long hotSearchId;

    @ApiModelProperty("店铺ID 0为全局热搜")
    private Long shopId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("顺序")
    private Integer seq;

    @ApiModelProperty("状态 0下线 1上线")
    private Integer status;

    @ApiModelProperty("热搜标题")
    private String title;

	public Long getHotSearchId() {
		return hotSearchId;
	}

	public void setHotSearchId(Long hotSearchId) {
		this.hotSearchId = hotSearchId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "HotSearchDTO{" +
				"hotSearchId=" + hotSearchId +
				",shopId=" + shopId +
				",content=" + content +
				",seq=" + seq +
				",status=" + status +
				",title=" + title +
				'}';
	}
}
