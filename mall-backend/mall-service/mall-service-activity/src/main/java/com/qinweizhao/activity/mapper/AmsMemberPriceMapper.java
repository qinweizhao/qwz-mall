package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsMemberPrice;

import java.util.List;

/**
 * 商品会员价格Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsMemberPriceMapper {
    /**
     * 查询商品会员价格
     *
     * @param id 商品会员价格主键
     * @return 商品会员价格
     */
    AmsMemberPrice selectAmsMemberPriceById(Long id);

    /**
     * 查询商品会员价格列表
     *
     * @param amsMemberPrice 商品会员价格
     * @return 商品会员价格集合
     */
    List<AmsMemberPrice> selectAmsMemberPriceList(AmsMemberPrice amsMemberPrice);

    /**
     * 新增商品会员价格
     *
     * @param amsMemberPrice 商品会员价格
     * @return 结果
     */
    int insertAmsMemberPrice(AmsMemberPrice amsMemberPrice);

    /**
     * 修改商品会员价格
     *
     * @param amsMemberPrice 商品会员价格
     * @return 结果
     */
    int updateAmsMemberPrice(AmsMemberPrice amsMemberPrice);

    /**
     * 删除商品会员价格
     *
     * @param id 商品会员价格主键
     * @return 结果
     */
    int deleteAmsMemberPriceById(Long id);

    /**
     * 批量删除商品会员价格
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsMemberPriceByIds(Long[] ids);
}
