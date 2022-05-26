package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsMemberReceiveAddress;
import com.qinweizhao.user.mapper.UmsMemberReceiveAddressMapper;
import com.qinweizhao.user.service.UmsMemberReceiveAddressService;
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
public class UmsMemberReceiveAddressServiceImpl extends QwzServiceImpl<UmsMemberReceiveAddressMapper, UmsMemberReceiveAddress> implements UmsMemberReceiveAddressService {
    @Resource
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

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


}
