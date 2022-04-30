package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.UmsMemberCollectSpu;
import com.qinweizhao.user.mapper.UmsMemberCollectSpuMapper;
import com.qinweizhao.user.service.UmsMemberCollectSpuService;
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
public class UmsMemberCollectSpuServiceImpl extends QwzServiceImpl<UmsMemberCollectSpuMapper, UmsMemberCollectSpu> implements UmsMemberCollectSpuService {
    @Resource
    private UmsMemberCollectSpuMapper umsMemberCollectSpuMapper;

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品
     */
    @Override
    public List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu) {
        return umsMemberCollectSpuMapper.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
    }

}
