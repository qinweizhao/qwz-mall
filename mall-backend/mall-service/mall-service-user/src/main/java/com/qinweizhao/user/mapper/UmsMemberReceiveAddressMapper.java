package com.qinweizhao.user.mapper;

import com.qinweizhao.user.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberReceiveAddressMapper {
    /**
     * 查询会员收货地址
     *
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    public UmsMemberReceiveAddress selectUmsMemberReceiveAddressById(Long id);

    /**
     * 查询会员收货地址列表
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    public List<UmsMemberReceiveAddress> selectUmsMemberReceiveAddressList(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 新增会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    public int insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 修改会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    public int updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 删除会员收货地址
     *
     * @param id 会员收货地址主键
     * @return 结果
     */
    public int deleteUmsMemberReceiveAddressById(Long id);

    /**
     * 批量删除会员收货地址
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberReceiveAddressByIds(Long[] ids);
}
