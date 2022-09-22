package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsCollectSpu;
import com.qinweizhao.user.mapper.UmsCollectSpuMapper;
import com.qinweizhao.user.service.UmsCollectSpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收藏的商品Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsCollectSpuServiceImpl extends QwzServiceImpl<UmsCollectSpuMapper, UmsCollectSpu> implements UmsCollectSpuService {
    @Resource
    private UmsCollectSpuMapper umsCollectSpuMapper;

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsCollectSpu 会员收藏的商品
     * @return 会员收藏的商品
     */
    @Override
    public List<UmsCollectSpu> selectUmsMemberCollectSpuList(UmsCollectSpu umsCollectSpu) {
        return umsCollectSpuMapper.selectUmsMemberCollectSpuList(umsCollectSpu);
    }

}
