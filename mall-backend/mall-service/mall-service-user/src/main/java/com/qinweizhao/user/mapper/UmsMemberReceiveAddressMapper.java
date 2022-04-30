package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.user.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberReceiveAddressMapper extends QwzBaseMapper<UmsMemberReceiveAddress> {


    /**
     * 查询会员收货地址列表
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    public List<UmsMemberReceiveAddress> selectUmsMemberReceiveAddressList(UmsMemberReceiveAddress umsMemberReceiveAddress);


}
