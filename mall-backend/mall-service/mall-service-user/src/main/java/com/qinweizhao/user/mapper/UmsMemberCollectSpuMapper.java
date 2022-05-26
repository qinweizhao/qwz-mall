package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.user.model.entity.UmsMemberCollectSpu;

import java.util.List;

/**
 * 会员收藏的商品Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberCollectSpuMapper extends QwzBaseMapper<UmsMemberCollectSpu> {

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu);

    ;
}
