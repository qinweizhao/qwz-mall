package com.mall4j.cloud.biz.vo;

import com.mall4j.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 上传文件记录表VO
 *
 * @author YXF
 * @date 2020-11-21 10:21:40
 */
public class AttachFileVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty()
    private Long fileId;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("文件类型")
    private String fileType;

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件大小")
    private Integer fileSize;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("文件 1:图片 2:视频 3:文件")
    private Integer type;

	@ApiModelProperty("分组id")
	private Long attachFileGroupId;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getAttachFileGroupId() {
		return attachFileGroupId;
	}

	public void setAttachFileGroupId(Long attachFileGroupId) {
		this.attachFileGroupId = attachFileGroupId;
	}

	@Override
	public String toString() {
		return "AttachFileVO{" +
				"fileId=" + fileId +
				", filePath='" + filePath + '\'' +
				", fileType='" + fileType + '\'' +
				", fileName='" + fileName + '\'' +
				", fileSize=" + fileSize +
				", shopId=" + shopId +
				", type=" + type +
				", attachFileGroupId=" + attachFileGroupId +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
