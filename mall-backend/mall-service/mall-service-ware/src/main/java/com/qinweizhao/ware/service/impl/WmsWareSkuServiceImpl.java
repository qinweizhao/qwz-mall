package com.qinweizhao.ware.service.impl;

import com.qinweizhao.api.ware.dto.SkuHasStockDTO;
import com.qinweizhao.ware.mapper.WmsWareSkuMapper;
import com.qinweizhao.ware.model.entity.WmsWareSku;
import com.qinweizhao.ware.service.IWmsWareSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品库存Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsWareSkuServiceImpl implements IWmsWareSkuService {
    @Resource
    private WmsWareSkuMapper wmsWareSkuMapper;

    /**
     * 查询商品库存
     *
     * @param id 商品库存主键
     * @return 商品库存
     */
    @Override
    public WmsWareSku selectWmsWareSkuById(Long id) {
        return wmsWareSkuMapper.selectWmsWareSkuById(id);
    }

    /**
     * 查询商品库存列表
     *
     * @param wmsWareSku 商品库存
     * @return 商品库存
     */
    @Override
    public List<WmsWareSku> selectWmsWareSkuList(WmsWareSku wmsWareSku) {
        return wmsWareSkuMapper.selectWmsWareSkuList(wmsWareSku);
    }

    /**
     * 新增商品库存
     *
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    @Override
    public int insertWmsWareSku(WmsWareSku wmsWareSku) {
        return wmsWareSkuMapper.insertWmsWareSku(wmsWareSku);
    }

    /**
     * 修改商品库存
     *
     * @param wmsWareSku 商品库存
     * @return 结果
     */
    @Override
    public int updateWmsWareSku(WmsWareSku wmsWareSku) {
        return wmsWareSkuMapper.updateWmsWareSku(wmsWareSku);
    }

    /**
     * 批量删除商品库存
     *
     * @param ids 需要删除的商品库存主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareSkuByIds(Long[] ids) {
        return wmsWareSkuMapper.deleteWmsWareSkuByIds(ids);
    }

    /**
     * 删除商品库存信息
     *
     * @param id 商品库存主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareSkuById(Long id) {
        return wmsWareSkuMapper.deleteWmsWareSkuById(id);
    }

    @Override
    public List<SkuHasStockDTO> listHasStockBySkuIds(List<Long> skuIds) {
        return skuIds.stream().map(skuId -> {
            SkuHasStockDTO hasStockDTO = new SkuHasStockDTO();

            //查询当前sku的总库存量

            Long count = wmsWareSkuMapper.selectSkuStock(skuId);

            hasStockDTO.setSkuId(skuId);
            hasStockDTO.setHasStock(count != null && count > 0);
            return hasStockDTO;
        }).collect(Collectors.toList());
    }
}
