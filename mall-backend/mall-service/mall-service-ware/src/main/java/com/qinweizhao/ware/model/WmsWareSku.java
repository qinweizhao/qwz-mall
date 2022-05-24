package com.qinweizhao.ware.model;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品库存对象 wms_ware_sku
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public class WmsWareSku extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * 仓库id
     */
    @Excel(name = "仓库id")
    private Long wareId;

    /**
     * 库存数
     */
    @Excel(name = "库存数")
    private Long stock;

    /**
     * sku_name
     */
    @Excel(name = "sku_name")
    private String skuName;

    /**
     * 锁定库存
     */
    @Excel(name = "锁定库存")
    private Long stockLocked;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Long getWareId() {
        return wareId;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStock() {
        return stock;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setStockLocked(Long stockLocked) {
        this.stockLocked = stockLocked;
    }

    public Long getStockLocked() {
        return stockLocked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("skuId", getSkuId())
                .append("wareId", getWareId())
                .append("stock", getStock())
                .append("skuName", getSkuName())
                .append("stockLocked", getStockLocked())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
