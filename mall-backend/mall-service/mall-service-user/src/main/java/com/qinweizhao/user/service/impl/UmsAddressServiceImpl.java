package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsAddress;
import com.qinweizhao.user.mapper.UmsAddressMapper;
import com.qinweizhao.user.service.UmsAddressService;
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
public class UmsAddressServiceImpl extends QwzServiceImpl<UmsAddressMapper, UmsAddress> implements UmsAddressService {
    @Resource
    private UmsAddressMapper umsAddressMapper;

    /**
     * 查询会员收货地址列表
     *
     * @param umsAddress 会员收货地址
     * @return 会员收货地址
     */
    @Override
    public List<UmsAddress> selectUmsMemberReceiveAddressList(UmsAddress umsAddress) {
        return umsAddressMapper.selectUmsMemberReceiveAddressList(umsAddress);
    }


}
