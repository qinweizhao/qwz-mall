package com.mall4j.cloud.order.vo;

import com.mall4j.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 订单信息
 *
 * @author FrozenWatermelon
 * @date 2020-12-05 14:13:50
 */
public class OrderVO extends BaseVO {

	@ApiModelProperty(value = "订单ID")
    private Long orderId;

	@ApiModelProperty(value = "店铺id")
    private Long shopId;

	@ApiModelProperty(value = "用户ID")
    private Long userId;

	@ApiModelProperty(value = "店铺名称")
	private String shopName;

	@ApiModelProperty(value = "总值")
    private Long total;

	@ApiModelProperty(value = "订单状态 1:待付款 2:待发货 3:待收货(已发货) 5:成功 6:失败")
    private Integer status;

	@ApiModelProperty(value = "配送类型 3：无需快递")
    private Integer deliveryType;

	@ApiModelProperty(value = "订单关闭原因 1-超时未支付 4-买家取消 15-已通过货到付款交易")
    private Integer closeType;

	@ApiModelProperty(value = "订单商品总数")
    private Integer allCount;

	@ApiModelProperty(value = "付款时间")
    private Date payTime;

	@ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

	@ApiModelProperty(value = "完成时间")
    private Date finallyTime;

	@ApiModelProperty(value = "取消时间")
    private Date cancelTime;

	@ApiModelProperty(value = "是否已支付，1.已支付0.未支付")
    private Integer isPayed;

	@ApiModelProperty(value = "用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除")
    private Integer deleteStatus;

	@ApiModelProperty(value = "订单项")
	private List<OrderItemVO> orderItems;

	@ApiModelProperty(value = "订单地址")
	private OrderAddrVO orderAddr;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getCloseType() {
		return closeType;
	}

	public void setCloseType(Integer closeType) {
		this.closeType = closeType;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getFinallyTime() {
		return finallyTime;
	}

	public void setFinallyTime(Date finallyTime) {
		this.finallyTime = finallyTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Integer getIsPayed() {
		return isPayed;
	}

	public void setIsPayed(Integer isPayed) {
		this.isPayed = isPayed;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public List<OrderItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemVO> orderItems) {
		this.orderItems = orderItems;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public OrderAddrVO getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(OrderAddrVO orderAddr) {
		this.orderAddr = orderAddr;
	}

	@Override
	public String toString() {
		return "OrderVO{" +
				"orderId=" + orderId +
				", shopId=" + shopId +
				", userId=" + userId +
				", shopName='" + shopName + '\'' +
				", total=" + total +
				", status=" + status +
				", deliveryType=" + deliveryType +
				", closeType=" + closeType +
				", allCount=" + allCount +
				", payTime=" + payTime +
				", deliveryTime=" + deliveryTime +
				", finallyTime=" + finallyTime +
				", cancelTime=" + cancelTime +
				", isPayed=" + isPayed +
				", deleteStatus=" + deleteStatus +
				", orderItems=" + orderItems +
				", orderAddr=" + orderAddr +
				'}';
	}
}
