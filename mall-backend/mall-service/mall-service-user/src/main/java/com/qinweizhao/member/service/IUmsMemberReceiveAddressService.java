package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberReceiveAddressService {
    /**
     * 查询会员收货地址
     *
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    UmsMemberReceiveAddress selectUmsMemberReceiveAddressById(Long id);

    /**
     * 查询会员收货地址列表
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    List<UmsMemberReceiveAddress> selectUmsMemberReceiveAddressList(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 新增会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    int insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 修改会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    int updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 批量删除会员收货地址
     *
     * @param ids 需要删除的会员收货地址主键集合
     * @return 结果
     */
    int deleteUmsMemberReceiveAddressByIds(Long[] ids);

    /**
     * 删除会员收货地址信息
     *
     * @param id 会员收货地址主键
     * @return 结果
     */
    int deleteUmsMemberReceiveAddressById(Long id);
}
