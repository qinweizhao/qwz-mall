package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.domain.UmsMemberCollectSpu;
import com.qinweizhao.product.mapper.UmsMemberCollectSpuMapper;
import com.qinweizhao.product.service.IUmsMemberCollectSpuService;
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
public class UmsMemberCollectSpuServiceImpl implements IUmsMemberCollectSpuService {
    @Resource
    private UmsMemberCollectSpuMapper umsMemberCollectSpuMapper;

    /**
     * 查询会员收藏的商品
     *
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    @Override
    public UmsMemberCollectSpu selectUmsMemberCollectSpuById(Long id) {
        return umsMemberCollectSpuMapper.selectUmsMemberCollectSpuById(id);
    }

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

    /**
     * 新增会员收藏的商品
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int insertUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu) {
        umsMemberCollectSpu.setCreateTime(DateUtils.getNowDate());
        return umsMemberCollectSpuMapper.insertUmsMemberCollectSpu(umsMemberCollectSpu);
    }

    /**
     * 修改会员收藏的商品
     *
     * @param umsMemberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int updateUmsMemberCollectSpu(UmsMemberCollectSpu umsMemberCollectSpu) {
        return umsMemberCollectSpuMapper.updateUmsMemberCollectSpu(umsMemberCollectSpu);
    }

    /**
     * 批量删除会员收藏的商品
     *
     * @param ids 需要删除的会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSpuByIds(Long[] ids) {
        return umsMemberCollectSpuMapper.deleteUmsMemberCollectSpuByIds(ids);
    }

    /**
     * 删除会员收藏的商品信息
     *
     * @param id 会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSpuById(Long id) {
        return umsMemberCollectSpuMapper.deleteUmsMemberCollectSpuById(id);
    }
}
