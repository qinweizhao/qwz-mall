package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsSkuLadder;

import java.util.List;

/**
 * 商品阶梯价格Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSkuLadderService {
    /**
     * 查询商品阶梯价格
     *
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    AmsSkuLadder selectAmsSkuLadderById(Long id);

    /**
     * 查询商品阶梯价格列表
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格集合
     */
    List<AmsSkuLadder> selectAmsSkuLadderList(AmsSkuLadder amsSkuLadder);

    /**
     * 新增商品阶梯价格
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 结果
     */
    int insertAmsSkuLadder(AmsSkuLadder amsSkuLadder);

    /**
     * 修改商品阶梯价格
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 结果
     */
    int updateAmsSkuLadder(AmsSkuLadder amsSkuLadder);

    /**
     * 批量删除商品阶梯价格
     *
     * @param ids 需要删除的商品阶梯价格主键集合
     * @return 结果
     */
    int deleteAmsSkuLadderByIds(Long[] ids);

    /**
     * 删除商品阶梯价格信息
     *
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    int deleteAmsSkuLadderById(Long id);
}
