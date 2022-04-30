package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.UmsMemberCollectSpu;

import java.util.List;

/**
 * 会员收藏的商品Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberCollectSpuService {
    /**
     * 查询会员收藏的商品
     *
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    UmsMemberCollectSpu selectUmsMemberCollectSpuById(Long id);

    /**
     * 查询会员收藏的商品列表
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品集合
     */
    List<UmsMemberCollectSpu> selectUmsMemberCollectSpuList(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 新增会员收藏的商品
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    int insertUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 修改会员收藏的商品
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    int updateUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu);

    /**
     * 批量删除会员收藏的商品
     *
     * @param ids 需要删除的会员收藏的商品主键集合
     * @return 结果
     */
    int deleteUmsMemberCollectSpuByIds(Long[] ids);

    /**
     * 删除会员收藏的商品信息
     *
     * @param id 会员收藏的商品主键
     * @return 结果
     */
    int deleteUmsMemberCollectSpuById(Long id);
}
