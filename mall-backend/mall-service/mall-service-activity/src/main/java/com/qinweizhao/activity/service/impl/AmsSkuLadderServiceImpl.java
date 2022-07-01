package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSkuLadderMapper;
import com.qinweizhao.activity.model.entity.AmsSkuLadder;
import com.qinweizhao.activity.service.IAmsSkuLadderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品阶梯价格Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSkuLadderServiceImpl implements IAmsSkuLadderService {
    @Resource
    private AmsSkuLadderMapper amsSkuLadderMapper;

    /**
     * 查询商品阶梯价格
     *
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    @Override
    public AmsSkuLadder selectAmsSkuLadderById(Long id) {
        return amsSkuLadderMapper.selectAmsSkuLadderById(id);
    }

    /**
     * 查询商品阶梯价格列表
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格
     */
    @Override
    public List<AmsSkuLadder> selectAmsSkuLadderList(AmsSkuLadder amsSkuLadder) {
        return amsSkuLadderMapper.selectAmsSkuLadderList(amsSkuLadder);
    }

    /**
     * 新增商品阶梯价格
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int insertAmsSkuLadder(AmsSkuLadder amsSkuLadder) {
        amsSkuLadder.setCreateTime(LocalDateTime.now());
        return amsSkuLadderMapper.insertAmsSkuLadder(amsSkuLadder);
    }

    /**
     * 修改商品阶梯价格
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int updateAmsSkuLadder(AmsSkuLadder amsSkuLadder) {
        amsSkuLadder.setUpdateTime(LocalDateTime.now());
        return amsSkuLadderMapper.updateAmsSkuLadder(amsSkuLadder);
    }

    /**
     * 批量删除商品阶梯价格
     *
     * @param ids 需要删除的商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuLadderByIds(Long[] ids) {
        return amsSkuLadderMapper.deleteAmsSkuLadderByIds(ids);
    }

    /**
     * 删除商品阶梯价格信息
     *
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuLadderById(Long id) {
        return amsSkuLadderMapper.deleteAmsSkuLadderById(id);
    }
}
