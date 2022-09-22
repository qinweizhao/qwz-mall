package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.user.model.entity.UmsCollectSpu;

import java.util.List;

/**
 * 会员收藏的商品Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsCollectSpuMapper extends QwzMapper<UmsCollectSpu> {

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<UmsCollectSpu> selectUmsMemberCollectSpuList(UmsCollectSpu umsCollectSpu);

    ;
}
