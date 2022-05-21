package com.qinweizhao.ware.service;

import com.qinweizhao.api.ware.dto.SkuHasStockDTO;
import com.qinweizhao.ware.model.WmsWareSku;

import java.util.List;

/**
 * 商品库存Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsWareSkuService {
    /**
     * 查询商品库存
     *
     * @param id 商品库存主键
     * @return 商品库存
     */
    WmsWareSku selectWmsWareSkuById(Long id);

    /**
     * 查询商品库存列表
     *
     * @param wmsWareSku 商品库存
     * @return 商品库存集合
     */
    List<WmsWareSku> selectWmsWareSkuList(WmsWareSku wmsWareSku);

    /**
     * 新增商品库存
     *
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    int insertWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 修改商品库存
     *
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    int updateWmsWareSku(WmsWareSku wmsWareSku);

    /**
     * 批量删除商品库存
     *
     * @param ids 需要删除的商品库存主键集合
     * @return 结果
     */
    int deleteWmsWareSkuByIds(Long[] ids);

    /**
     * 删除商品库存信息
     *
     * @param id 商品库存主键
     * @return 结果
     */
    int deleteWmsWareSkuById(Long id);

    /**
     * 查询是否有库存
     * @param skuIds skuIds
     * @return List
     */
    List<SkuHasStockDTO> listHasStockBySkuIds(List<Long> skuIds);
}
