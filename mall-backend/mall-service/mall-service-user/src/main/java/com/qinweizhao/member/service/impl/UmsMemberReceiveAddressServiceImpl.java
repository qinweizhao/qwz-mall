package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.UmsMemberReceiveAddress;
import com.qinweizhao.product.mapper.UmsMemberReceiveAddressMapper;
import com.qinweizhao.product.service.IUmsMemberReceiveAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收货地址Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements IUmsMemberReceiveAddressService {
    @Resource
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    /**
     * 查询会员收货地址
     *
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    @Override
    public UmsMemberReceiveAddress selectUmsMemberReceiveAddressById(Long id) {
        return umsMemberReceiveAddressMapper.selectUmsMemberReceiveAddressById(id);
    }

    /**
     * 查询会员收货地址列表
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 会员收货地址
     */
    @Override
    public List<UmsMemberReceiveAddress> selectUmsMemberReceiveAddressList(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return umsMemberReceiveAddressMapper.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
    }

    /**
     * 新增会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return umsMemberReceiveAddressMapper.insertUmsMemberReceiveAddress(umsMemberReceiveAddress);
    }

    /**
     * 修改会员收货地址
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return umsMemberReceiveAddressMapper.updateUmsMemberReceiveAddress(umsMemberReceiveAddress);
    }

    /**
     * 批量删除会员收货地址
     *
     * @param ids 需要删除的会员收货地址主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberReceiveAddressByIds(Long[] ids) {
        return umsMemberReceiveAddressMapper.deleteUmsMemberReceiveAddressByIds(ids);
    }

    /**
     * 删除会员收货地址信息
     *
     * @param id 会员收货地址主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberReceiveAddressById(Long id) {
        return umsMemberReceiveAddressMapper.deleteUmsMemberReceiveAddressById(id);
    }
}
