package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.entity.UmsCollectSpu;

import java.util.List;

/**
 * 会员收藏的商品Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsCollectSpuService extends QwzService<UmsCollectSpu> {

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<UmsCollectSpu> selectUmsMemberCollectSpuList(UmsCollectSpu umsCollectSpu);

}
