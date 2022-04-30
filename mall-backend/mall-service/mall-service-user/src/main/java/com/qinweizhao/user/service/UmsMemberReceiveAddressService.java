package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberReceiveAddressService extends QwzService<UmsMemberReceiveAddress> {


    /**
     * 查询会员收货地址列表
     *
     * @param umsMemberReceiveAddress 会员收货地址
     * @return 会员收货地址集合
     */
    List<UmsMemberReceiveAddress> selectUmsMemberReceiveAddressList(UmsMemberReceiveAddress umsMemberReceiveAddress);


}
