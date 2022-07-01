package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSkuLadder;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 商品阶梯价格Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSkuLadderMapper extends QwzBaseMapper<AmsSkuLadder> {
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
     * 删除商品阶梯价格
     *
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    int deleteAmsSkuLadderById(Long id);

    /**
     * 批量删除商品阶梯价格
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSkuLadderByIds(Long[] ids);
}
