package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.user.model.entity.UmsAddress;

import java.util.List;

/**
 * 会员收货地址Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsAddressMapper extends QwzMapper<UmsAddress> {


    /**
     * 查询会员收货地址列表
     *
     * @param umsAddress 会员收货地址
     * @return 会员收货地址集合
     */
    public List<UmsAddress> selectUmsMemberReceiveAddressList(UmsAddress umsAddress);


}
