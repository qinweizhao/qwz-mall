package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.entity.UmsMemberCollectSpu;

import java.util.List;

/**
 * 会员收藏的商品Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberCollectSpuService extends QwzService<UmsMemberCollectSpu> {

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu);

}
